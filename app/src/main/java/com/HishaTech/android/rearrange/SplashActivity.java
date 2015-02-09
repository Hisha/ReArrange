package com.HishaTech.android.rearrange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.HishaTech.android.rearrange.db.FillTable;

/**
 * Created by smithkev on 2/9/2015.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (!Utils.DatabaseExists(this)) {

            FillTable.Words(this);

            int myTimer = 1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish(); // close this activity
                }
            }, myTimer);

        } else {

            int myTimer = 3000;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish(); // close this activity
                }
            }, myTimer);

        }

    }

}
