package com.ucsdextandroid2.android2final

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class DataSources private constructor(){

    private var baseOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()

    private val metaDataAPI: MetaDataAPI = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(baseOkHttpClient)
        .baseUrl("https://www.metaweather.com")
        .build()
        .create(MetaDataAPI::class.java)

    fun search(searchTerm: String, callback: Callback<List<MetaWeatherItem>>) {

        metaDataAPI.searchWeather(searchTerm).enqueue(object: retrofit2.Callback<List<MetaWeatherItem>> {
            override fun onResponse(call: Call<List<MetaWeatherItem>>, response: Response<List<MetaWeatherItem>>) {
                callback.onDataFetched(if(response.isSuccessful) response.body().orEmpty() else emptyList())
            }

            override fun onFailure(call: Call<List<MetaWeatherItem>>, t: Throwable) {
                callback.onDataFetched(emptyList<MetaWeatherItem>())
            }
        })

    }

    interface Callback<T> {
        fun onDataFetched(data: T)
    }

    interface MetaDataAPI {
        @GET("/api/location/search/)")
        fun searchWeather(@Query("query") term: String): Call<List<MetaWeatherItem>>
    }

    companion object {

        private var instance: DataSources? = null

        @JvmStatic
        fun getInstance(): DataSources {
            if(instance == null)
                instance = DataSources()

            return instance!!
        }
    }
}
