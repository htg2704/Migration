package com.example.migration.Stats;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.migration.Contact;
import com.example.migration.MainActivity;
import com.example.migration.R;

public class stats_main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
    }
    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(stats_main.this, MainActivity.class);
        startActivity(intent);
    }
}
