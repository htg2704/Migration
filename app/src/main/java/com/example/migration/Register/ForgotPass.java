package com.example.migration.Register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.example.migration.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Toast;

public class ForgotPass extends AppCompatActivity {

    Toolbar toolbar;
    ProgressBar progressBar;
    EditText usreml;
    Button usrPass;

    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.progressBar);
        usreml = findViewById(R.id.usreml);
        usrPass = findViewById(R.id.btnForgotPass);

        toolbar.setTitle("Forgot Password");
        firebaseAuth = FirebaseAuth.getInstance();
        usrPass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(usreml.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>(){
                    @Override
                    public void onComplete(@NonNull Task<Void> task){
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPass.this,"Password send! Check Email",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(ForgotPass.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }

                });
            }

        });

    }
}
