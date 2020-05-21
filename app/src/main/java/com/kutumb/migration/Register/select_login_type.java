package com.kutumb.migration.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.kutumb.migration.Contact;
import com.kutumb.migration.MainActivity;
import com.kutumb.migration.R;
import com.kutumb.migration.Services;
import com.kutumb.migration.notifcation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class select_login_type extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton notification;
    private long backPressedTime = 0;
    String s1[];
    int images[]={R.drawable.migrant,R.drawable.migrant2,R.drawable.migrantworker3};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_type);


        Button buttonOpenBottomSheet = findViewById(R.id.btn_vol);
        buttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog =new BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(),"BottomSheet");
            }
        });


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



        recyclerView = findViewById(R.id.recyclerView);


        s1 = getResources().getStringArray(R.array.register1);

        final int time = 2000;
        final MyAdapterRegister myAdapter = new MyAdapterRegister(this,s1,images);
        recyclerView.setAdapter(myAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        final LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(recyclerView);

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (myAdapter.getItemCount() - 1)) {

                    linearLayoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }

                else if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == (myAdapter.getItemCount() - 1)) {

                    linearLayoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 0);
                }
            }
        }, 0, time);

        notification  = (ImageButton) findViewById(R.id.btn_notify);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(select_login_type.this,notifcation.class);
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