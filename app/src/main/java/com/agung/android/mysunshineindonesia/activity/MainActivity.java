package com.agung.android.mysunshineindonesia.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.agung.android.mysunshineindonesia.R;
import com.agung.android.mysunshineindonesia.adapter.WeatherAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_today)
    TextView mTvToday;
    @BindView(R.id.tv_weather_desc)
    TextView mWeatherdesc;
    @BindView(R.id.tv_weather_temp)
    TextView mWeathertemp;
    @BindView(R.id.iv_weather_image)
    ImageView mWeatherImage;
    @BindView(R.id.rv_weather_list)
    RecyclerView mWeatherList;

    private WeatherAdapter weatherAdapter;

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        ButterKnife.bind(this);

        mWeatherList.setLayoutManager(new LinearLayoutManager(this));
        mWeatherList.setHasFixedSize(true);

        mTvToday.setText("Minggu");
        mWeatherImage.setImageResource(R.mipmap.ic_launcher);
        mWeatherdesc.setText("Cuaca Berawan");
        mWeathertemp.setText("100" + getString(R.string.degree));

        weatherAdapter = new WeatherAdapter();
        mWeatherList.setAdapter(weatherAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            weatherAdapter.setWeatherData(null);
            loadWeatherData();
            return true;
        }
        if (id == R.id.action_map) {
            openLocationMap();
            return true;
        }

//        if (item.getItemId() == R.id.action_setting) {
//            Toast.makeText(this, "Ini Menu Setting", Toast.LENGTH_SHORT).show();
//            return true;
//        } else {
        return super.onOptionsItemSelected(item);
//
    }

    private void openLocationMap() {
        String addressString =  "1600 Amphitheather Parkway, CA";
        Uri geoLocation = Uri.parse("geo:0,0?q=" + addressString);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else {
            Log.d(TAG, "Couldn't call " + geoLocation.toString()
                    + ", no receiving apps installed!");
        }
    }

    private void loadWeatherData() {
    }

}
