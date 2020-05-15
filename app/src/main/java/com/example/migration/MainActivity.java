package com.example.migration;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.migration.Register.select_login_type;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    CardView enter_register,enter_data,enter_stats,enter_contact;
    ProgressDialog dialog;
    private long backPressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_reg:
                        startActivity(new Intent(getApplicationContext(), select_login_type.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_services:
                        startActivity(new Intent(getApplicationContext(),Services.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_contact:
                        startActivity(new Intent(getApplicationContext(),Contact.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        enter_register = findViewById(R.id.btn_register);
        enter_data = findViewById(R.id.btn_data);
        enter_stats = findViewById(R.id.btn_stats);
        enter_contact = findViewById(R.id.contact);

        enter_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(),com.example.migration.Register.select_login_type.class);
                        startActivity(intent);
                    }
                }, 1100);


            }
        });
        enter_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent i = new Intent(getApplicationContext(), com.example.migration.data.data_main.class);
                        startActivity(i);
                    }
                }, 1500);
            }
        });

        enter_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent i=new Intent(getApplicationContext(),com.example.migration.Stats.stats_main.class);
                        startActivity(i);
                    }
                }, 1500);

            }
        });
        enter_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertadd = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(),Contact.class);
                        startActivity(intent);
                    }
                }, 1100);


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
