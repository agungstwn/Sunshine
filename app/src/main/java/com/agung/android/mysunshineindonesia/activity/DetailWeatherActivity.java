package com.agung.android.mysunshineindonesia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.agung.android.mysunshineindonesia.R;

/**
 * Created by agung on 14/01/18.
 */

public class DetailWeatherActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    ShareActionProvider shareActionProvider;
    private String mForecast;
    private TextView mWeatherDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        mWeatherDisplay = (TextView) findViewById(R.id.detail_weather_date);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                mForecast = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                mWeatherDisplay.setText(mForecast);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForecastIntent());
        return true;


    }

    private Intent createShareForecastIntent() {
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(mForecast + FORECAST_SHARE_HASHTAG)
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            Toast.makeText(this, "Share Ramalan Cuaca", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBodyText = "Check it out. Your message goes here";
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            intent.putExtra(Intent.EXTRA_TEXT, createShareForecastIntent());
            startActivity(Intent.createChooser(intent, "sharing intent"));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
