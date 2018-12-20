package com.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.volleyexample.JsonRequestType.JsonObjectRequestVolley;
import com.volleyexample.JsonRequestType.JsonStringRequestVolley;
import com.volleyexample.timber.ReleaseTree;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }

        JsonStringRequestVolley jsonObjectRequestVolley= new JsonStringRequestVolley(this);
        jsonObjectRequestVolley.Call();
    }
}
