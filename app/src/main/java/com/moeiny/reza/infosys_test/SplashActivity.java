package com.moeiny.reza.infosys_test;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Give The Jason Object from URL

        new AsyncTaskInfo("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json").execute();
        
        final Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ( !MainActivity.Info.equals("") ){
                                Intent intent=new Intent(G.context,MainActivity.class);
                                startActivity(intent);
                                timer.cancel();
                                finish();
                        }
                    }
                });
            }
        },1,1000);
    }
}
