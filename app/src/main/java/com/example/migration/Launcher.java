package com.example.migration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Launcher extends AppCompatActivity {

        Notification notification;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_launcher);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Launcher.this,MainActivity.class);
                        startActivity(intent);
                        Launcher.this.finish();
                    }
                },2000);

        }
    }

