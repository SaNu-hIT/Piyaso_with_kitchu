package com.piyaso.softforest.piyaso.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.piyaso.softforest.piyaso.R;


public class SplashScreen extends AppCompatActivity {
    public static final int TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(getBaseContext(),Login.class);
//                startActivity(intent);
//                finish();
//
//            }
//        },TIME_OUT);

    }

    public void signinMethord(View view) {
        Intent intent=new Intent(getBaseContext(),Login.class);
        startActivity(intent);
        finish();
    }

    public void getStarted(View view) {
        Intent intent=new Intent(getBaseContext(),MainHome.class);
        startActivity(intent);
        finish();
    }
}
