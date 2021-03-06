package com.samapps.restituo.ui.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import com.samapps.restituo.R;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DetailActivity extends AppCompatActivity {

    /*
    * try method k liye
    * /
    *
     */

    long seconds=0;
    long millis=0;
    int mCount=0;
    Timer timer;
    int progress = 100;
    int pStatus = 600000;
    private Handler handler = new Handler();
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressbar);
        mProgress.setProgress(100);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);
        tv = (TextView) findViewById(R.id.tv);


        // timer for seekbar
        final int oneMin = 10 * 60 * 1000; // 1 minute in milli seconds

        /** CountDownTimer starts with 1 minutes and every onTick is 1 second */
        new CountDownTimer(oneMin, 1000) {
            public void onTick(long millisUntilFinished) {

                //forward progress
                long finishedSeconds = oneMin - millisUntilFinished;
                int total = (int) (((float)finishedSeconds / (float)oneMin) * 100.0);
                //progress-=1;
                //mProgress.setProgress(progress);
                progress= (int) (progress-0.01);
                mProgress.setProgress(progress);
                tv.setText(mProgress.getProgress() + "%");


            }

            public void onFinish() {
                // DO something when 1 minute is up
                Toast.makeText(getApplicationContext(),"Donee",Toast.LENGTH_LONG).show();
            }
        }.start();
    }

}