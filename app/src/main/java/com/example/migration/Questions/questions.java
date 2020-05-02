package com.example.migration.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.migration.MainActivity;
import com.example.migration.Questions.ui.main.SectionsPagerAdapter;
import com.example.migration.R;
import com.example.migration.Register.LoginOrRegister;
import com.example.migration.Register.select_login_type;
import com.example.migration.common.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class questions extends AppCompatActivity {

    ImageButton logout,btn;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
         viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        LinearLayout tabStrip = (LinearLayout)tabs.getChildAt(0);
        for(int i = 0; i < tabStrip.getChildCount();i++){
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        logout=findViewById(R.id.btn_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.type!=1)
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(getApplicationContext(),User.type==1? select_login_type.class :LoginOrRegister.class);
                startActivity(intent);

            }
        });

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(questions.this, select_login_type.class);
                startActivity(intent);

            }
        });


    }

    public void selectTab(int position){
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(questions.this, select_login_type.class);
        startActivity(intent);
    }
}