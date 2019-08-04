package com.ucsdextandroid2.android2final;

import Search.OnItemClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by rjaylward on 2019-05-10
 */
public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView titleView;
    private TextView subtitleView;

    private MetaWeatherLocationItem currentSongItem;
    private OnItemClickListener<MetaWeatherLocationItem> clickListener;

    private WeatherViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null && currentSongItem != null)
                    clickListener.onItemClicked(currentSongItem);
            }
        });
    }

    public static WeatherViewHolder inflate(@NonNull ViewGroup parent) {
        return new WeatherViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_search, parent, false));
    }

    public void bind(MetaWeatherLocationItem weatherItem) {
        this.currentSongItem = weatherItem;

        titleView.setText(weatherItem.getTitle());
        subtitleView.setText(String.format("%s • %s", weatherItem.getTheTemperature(), weatherItem.getTime()));
    }

    public void setClickListener(OnItemClickListener<MetaWeatherLocationItem> clickListener) {
        this.clickListener = clickListener;
    }

}