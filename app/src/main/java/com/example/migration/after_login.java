package com.example.migration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.migration.Questions.questions;
import com.example.migration.Register.LoginOrRegister;
import com.example.migration.Register.bulk_data;
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
import com.google.firebase.auth.FirebaseAuth;

public class after_login extends AppCompatActivity {

    CardView enter_register,enter_data;
    ProgressDialog dialog;
    ImageButton logout,btn;
    private long backPressedTime = 0;
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);


        enter_register = findViewById(R.id.btn_register);
        enter_data = findViewById(R.id.bulk);
        logout = findViewById(R.id.btn_logout);

        enter_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(after_login.this);
                LayoutInflater factory = LayoutInflater.from(after_login.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(), questions.class);
                        startActivity(intent);
                    }
                }, 1100);
            }
        });

        enter_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(after_login.this);
                LayoutInflater factory = LayoutInflater.from(after_login.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent i = new Intent(getApplicationContext(), bulk_data.class);
                        startActivity(i);
                    }
                }, 1100);
            }
        });

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
                    mGoogleSignInClient= GoogleSignIn.getClient(after_login.this, gso);
                    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(after_login.this);
                    if (account != null) {
                        mGoogleSignInClient.signOut()
                                .addOnCompleteListener(after_login.this, new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
                                        // ...
                                        Toast.makeText(after_login.this,"Google Signed Out",Toast.LENGTH_LONG);
                                    }
                                });

                    }
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(after_login.this);
                dialog.setTitle("Alert !");
                dialog.setMessage("Are you sure you want to Logout ?");
                dialog.setCancelable(true);

                dialog.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    id) {
                                Intent intent = new Intent(getApplicationContext(),User.type==1? select_login_type.class : LoginOrRegister.class);
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
                Intent intent = new Intent(after_login.this, select_login_type.class);
                startActivity(intent);

            }
        });


    }


    @Override
    public void onBackPressed() {

            AlertDialog.Builder dialog = new AlertDialog.Builder(after_login.this);
            dialog.setTitle("Alert !");
            dialog.setMessage("Are you sure you want to exit ?");
            dialog.setCancelable(true);

            dialog.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int
                                id) {
                            finish();
                            Intent intent = new Intent(after_login.this, select_login_type.class);
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
