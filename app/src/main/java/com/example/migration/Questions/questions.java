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

    ImageButton logout,btn;
    ViewPager viewPager;
    GoogleSignInClient mGoogleSignInClient;

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
                if(User.type!=1) {
                    FirebaseAuth.getInstance().signOut();
                    AccessToken accessToken = AccessToken.getCurrentAccessToken();
                    boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

                    if (isLoggedIn)
                        LoginManager.getInstance().logOut();

                     GoogleSignInOptions gso = new GoogleSignInOptions.Builder(com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN).
                            requestIdToken(getString(R.string.default_g_web_client_id))
                            .requestEmail()
                             .build();
                     mGoogleSignInClient= GoogleSignIn.getClient(questions.this, gso);
                    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(questions.this);
                    if (account != null) {
                        mGoogleSignInClient.signOut()
                                .addOnCompleteListener(questions.this, new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
                                        // ...
                                        Toast.makeText(questions.this,"Google Signed Out",Toast.LENGTH_LONG);
                                    }
                                });

                    }
                }

                    AlertDialog.Builder dialog = new AlertDialog.Builder(questions.this);
                    dialog.setTitle("Alert !");
                    dialog.setMessage("Are you sure you want to exit ?");
                    dialog.setCancelable(true);

                    dialog.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int
                                        id) {
                                    Intent intent = new Intent(getApplicationContext(),User.type==1? select_login_type.class :LoginOrRegister.class);
                                    startActivity(intent);


                                    finish();

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
