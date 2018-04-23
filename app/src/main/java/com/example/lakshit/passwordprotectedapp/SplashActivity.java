package com.example.lakshit.passwordprotectedapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences setting =getSharedPreferences("PREFS",0);
        password = setting.getString("password","");
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (password.equals("")) {
                    // if there is no password
                    Intent i = new Intent(getApplicationContext(), CreatePasswordActivity.class);
                    startActivity(i);
                    finish();
                }
                else {
                    // if there is a password
                    Intent i = new Intent(getApplicationContext(), EnterPasswordActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },2000);
    }
}
