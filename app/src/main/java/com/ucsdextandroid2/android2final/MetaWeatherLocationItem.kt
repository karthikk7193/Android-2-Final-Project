package com.ucsdextandroid2.android2final

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by rjaylward on 2019-05-18
 */
@Parcelize
class MetaWeatherLocationItem(

    @SerializedName("title") val title: String?,
    @SerializedName("location_type") val locationType: String?,
    @SerializedName("time") val time: String?,
    @SerializedName("woeid") val woeid: Long,
    @SerializedName("latt_long") val lattLong: String?,
    @SerializedName("sun_rise") val sunRise: String?,
    @SerializedName("sun_set") val sunSet: String?,
    @SerializedName("applicable_date") val date: String,
    @SerializedName("weather_state_name") val description: String? = null,
    @SerializedName("wind_speed") val windSpeed: Float,
    @SerializedName("wind_direction") val windDirection: Float,
    @SerializedName("(min_temp") val minTemperature: Int,
    @SerializedName("(max_temp") val maxTemperature: Int,
    @SerializedName("(the_temp") val theTemperature: Int,
    @SerializedName("humidity") val humidity: Float

) : Parcelable {
    fun bind(item: MetaWeatherLocationItem) {

    }
}