package com.kutumb.migration.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kutumb.migration.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;

public class ForgotPass extends AppCompatActivity {

    EditText usreml;
    Button usrPass;

    FirebaseAuth firebaseAuth;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        usreml = findViewById(R.id.usreml);
        usrPass = findViewById(R.id.btnForgotPass);




        firebaseAuth = FirebaseAuth.getInstance();
        usrPass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {




                String reg_mail_str = usreml.getText().toString();
                if (reg_mail_str.isEmpty()) {
                    usreml.setError("Please enter a valid email ID");
                    usreml.requestFocus();
                }
                else {

                    if (reg_mail_str.matches(emailPattern)) {

                        AlertDialog.Builder alertadd = new AlertDialog.Builder(ForgotPass.this);
                        LayoutInflater factory = LayoutInflater.from(ForgotPass.this);
                        view = factory.inflate(R.layout.sample, null);
                        alertadd.setView(view);
                        alertadd.show();
                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {

                                Intent intent = new Intent(getApplicationContext(), LoginOrRegister.class);
                                startActivity(intent);
                            }
                        }, 1200);

                        firebaseAuth.sendPasswordResetEmail(usreml.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgotPass.this, "Password send! Check Email", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(ForgotPass.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                }
                            }

                        });
                    }

                    else {
                        usreml.setError("Please enter a valid email ID");
                        usreml.requestFocus();
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(ForgotPass.this, LoginOrRegister.class);
        startActivity(intent);
    }
}
