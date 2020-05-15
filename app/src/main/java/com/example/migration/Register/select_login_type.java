package com.example.migration.Register;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.migration.Contact;
import com.example.migration.MainActivity;
import com.example.migration.R;
import com.example.migration.Services;
import com.example.migration.common.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class select_login_type extends AppCompatActivity {

    CardView btn_volunteer, btn_mobiliser, btn_agency;
    ImageButton back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_type);




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_reg);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_reg:
                        return true;
                    case R.id.nav_services:
                        startActivity(new Intent(getApplicationContext(), Services.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_contact:
                        startActivity(new Intent(getApplicationContext(), Contact.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


        User.type=0;

        btn_mobiliser=findViewById(R.id.btn_cmob);
        btn_volunteer=findViewById(R.id.btn_vol);
        btn_agency=findViewById(R.id.btn_ngo);
        back=findViewById(R.id.back);

        btn_volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.type=1;
                AlertDialog.Builder alertadd = new AlertDialog.Builder(select_login_type.this);
                LayoutInflater factory = LayoutInflater.from(select_login_type.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(select_login_type.this,com.example.migration.Questions.questions.class);
                        startActivity(intent);
                    }
                }, 1200);
            }
        });
        btn_mobiliser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.type=2;
                AlertDialog.Builder alertadd = new AlertDialog.Builder(select_login_type.this);
                LayoutInflater factory = LayoutInflater.from(select_login_type.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(select_login_type.this,com.example.migration.Register.LoginOrRegister.class);
                        startActivity(intent);
                    }
                }, 1200);


            }
        });
        btn_agency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.type=3;
                AlertDialog.Builder alertadd = new AlertDialog.Builder(select_login_type.this);
                LayoutInflater factory = LayoutInflater.from(select_login_type.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(select_login_type.this,com.example.migration.Register.LoginOrRegister.class);
                        startActivity(intent);
                    }
                }, 1200);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(select_login_type.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(select_login_type.this, MainActivity.class);
        startActivity(intent);
    }
}