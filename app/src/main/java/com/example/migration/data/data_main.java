package com.example.migration.data;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.migration.Contact;
import com.example.migration.MainActivity;
import com.example.migration.R;


public class data_main extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_main);
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(data_main.this, MainActivity.class);
        startActivity(intent);
    }
}
