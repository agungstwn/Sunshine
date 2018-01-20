package com.agung.android.mysunshineindonesia;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by agung on 20/01/18.
 */

public class App extends Application {
    private static App instance;
    private Retrofit retrofit;
    private Gson gson;
    private EventBus eventBus;

    public App(){
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createEventBus();
        createGson();
        createRetrofit();
    }

    private void createEventBus() {
        eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    private void createGson() {
        gson = new GsonBuilder().create();
    }

    private void createRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(WeatherApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Gson getGson() {
        return gson;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public WeatherApi getWeatherApi(){
        return getRetrofit().create(WeatherApi.class);
    }
}
