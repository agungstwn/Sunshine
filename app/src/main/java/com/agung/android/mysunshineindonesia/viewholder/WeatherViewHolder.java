package com.agung.android.mysunshineindonesia.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.agung.android.mysunshineindonesia.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by agung on 14/01/18.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.iv_weather_item_image)
    ImageView mWeatherImage;
    @BindView(R.id.tv_weather_item_date)
    TextView mWeatherDate;
    @BindView(R.id.tv_weather_item_desc)
    TextView mWeatherDesc;
    @BindView(R.id.tv_weather_item_temp)
    TextView mWeatherTemp;

    private final WeatherCallback callback;
    private static int WeatherLayout = R.layout.view_holder_weather;

    public WeatherViewHolder(View itemView, WeatherCallback callback) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.callback = callback;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        callback.onWeatherClick(this);
    }

    public interface WeatherCallback{
        void onWeatherClick(WeatherViewHolder holder);
    }

    public ImageView getmWeatherImage() {
        return mWeatherImage;
    }

    public TextView getmWeatherDate() {
        return mWeatherDate;
    }

    public TextView getmWeatherDesc() {
        return mWeatherDesc;
    }

    public TextView getmWeatherTemp() {
        return mWeatherTemp;
    }

    public static int getWeatherLayout(){
        return WeatherLayout;
    }
}
