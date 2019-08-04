package com.ucsdextandroid2.android2final

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataSources.getInstance().search("Burlington", object : DataSources.Callback<List<MetaWeatherLocationItem>> {

            override fun onDataFetched(data: List<MetaWeatherLocationItem>) {

            }

        })
    }
}
