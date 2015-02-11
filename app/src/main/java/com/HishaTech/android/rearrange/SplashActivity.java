package com.HishaTech.android.rearrange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.HishaTech.android.rearrange.db.AsyncFillWords01;
import com.HishaTech.android.rearrange.db.AsyncFillWords02;
import com.HishaTech.android.rearrange.db.AsyncFillWords03;
import com.HishaTech.android.rearrange.db.AsyncFillWords04;

/**
 * Created by smithkev on 2/9/2015.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (!Utils.DatabaseExists(this)) {

            AsyncFillWords01 afw01 = new AsyncFillWords01(this);
            afw01.execute();

            AsyncFillWords02 afw02 = new AsyncFillWords02(this);
            afw02.execute();

            AsyncFillWords03 afw03 = new AsyncFillWords03(this);
            afw03.execute();

            AsyncFillWords04 afw04 = new AsyncFillWords04(this);
            afw04.execute();

            int myTimer = 15000;
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
