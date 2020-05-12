package com.example.migration.Questions;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.migration.Questions.ui.main.SectionsPagerAdapter;
import com.example.migration.R;
import com.example.migration.Register.LoginOrRegister;
import com.example.migration.Register.select_login_type;
import com.example.migration.after_login;
import com.example.migration.common.User;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class questions extends AppCompatActivity {

    ImageButton btn;
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
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(User.type!=1) {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(questions.this);
                    dialog.setTitle("Alert !");
                    dialog.setMessage("Are you sure you want to exit ?");
                    dialog.setCancelable(true);

                    dialog.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int
                                        id) {
                                    finish();
                                    Intent intent = new Intent(questions.this, after_login.class);
                                    startActivity(intent);

                                }
                            });

                    dialog.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert = dialog.create();
                    alert.show();
                }
                else {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(questions.this);
                    dialog.setTitle("Alert !");
                    dialog.setMessage("Are you sure you want to exit ?");
                    dialog.setCancelable(true);

                    dialog.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int
                                        id) {
                                    finish();
                                    Intent intent = new Intent(questions.this, select_login_type.class);
                                    startActivity(intent);

                                }
                            });

                    dialog.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert = dialog.create();
                    alert.show();
                }
            }
        });


    }

    public void selectTab(int position){
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {

        if(User.type!=1) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(questions.this);
            dialog.setTitle("Alert !");
            dialog.setMessage("Are you sure you want to exit ?");
            dialog.setCancelable(true);

            dialog.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int
                                id) {
                            finish();
                            Intent intent = new Intent(questions.this, after_login.class);
                            startActivity(intent);

                        }
                    });

            dialog.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = dialog.create();
            alert.show();

        }
        else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(questions.this);
            dialog.setTitle("Alert !");
            dialog.setMessage("Are you sure you want to exit ?");
            dialog.setCancelable(true);

            dialog.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int
                                id) {
                            finish();
                            Intent intent = new Intent(questions.this, select_login_type.class);
                            startActivity(intent);

                        }
                    });

            dialog.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = dialog.create();
            alert.show();
        }
    }
    }
