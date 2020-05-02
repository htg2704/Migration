package com.example.migration;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    CardView enter_register,enter_data,enter_stats,enter_contact;

    private long backPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter_register = findViewById(R.id.btn_register);
        enter_data = findViewById(R.id.btn_data);
        enter_stats = findViewById(R.id.btn_stats);
        enter_contact = findViewById(R.id.contact);

        enter_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),com.example.migration.Register.select_login_type.class);
                startActivity(intent);

            }
        });
        enter_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),com.example.migration.data.data_main.class);
                startActivity(intent);
            }
        });
        enter_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),com.example.migration.Stats.stats_main.class);
                startActivity(intent);

            }
        });
        enter_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Contact.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed() {
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {
            backPressedTime = t;
            Toast.makeText(this, "Press back again to Exit ", Toast.LENGTH_SHORT).show();
        } else {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

}
