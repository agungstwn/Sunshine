package com.agung.android.mysunshineindonesia;

/**
 * Created by agung on 20/01/18.
 */

public class WeatherController {

    public void getWeatherList(){
        App.getInstance().getWeatherApi().getDailyForecast
                ("Jakarta", "json", "metric", 10, WeatherApi.API_KEY);
    }
}
