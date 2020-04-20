package com.example.migration.Questions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.migration.Questions.ui.main.SectionsPagerAdapter;
import com.example.migration.R;
import com.example.migration.Register.LoginOrRegister;
import com.example.migration.Register.select_login_type;
import com.example.migration.common.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class questions extends AppCompatActivity {

Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
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

    }
}