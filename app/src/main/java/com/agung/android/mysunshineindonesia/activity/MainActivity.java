package com.agung.android.mysunshineindonesia.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {
            Toast.makeText(this, "Ini Menu Setting", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
