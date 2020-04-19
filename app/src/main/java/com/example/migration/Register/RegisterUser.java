package com.example.migration.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.migration.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterUser extends AppCompatActivity {
     EditText reg_email;
     EditText reg_psd;
     EditText cnf_psd;

     EditText getReg_adrs;
     EditText getReg_phone;
     EditText getReg_name;

     Button reg_sgnup;

    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        reg_email=findViewById(R.id.reg_mail);
        reg_psd=findViewById(R.id.reg_pwd);
        reg_sgnup=findViewById(R.id.reg_sign_up);
        cnf_psd=findViewById(R.id.cnf_pwd);
        getReg_adrs=findViewById(R.id.reg_adrs);
        getReg_phone=findViewById(R.id.reg_phone);
        getReg_name=findViewById(R.id.reg_name);

        mFirebaseAuth=FirebaseAuth.getInstance();


        reg_sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reg_mail_str=reg_email.getText().toString();
                String reg_pwd_str=reg_psd.getText().toString();
                String cnf_pwd_str=cnf_psd.getText().toString();
                String reg_adrs_str=getReg_adrs.getText().toString();
                String reg_name_str=getReg_name.getText().toString();
                String reg_phone_str=getReg_phone.getText().toString();

                if(reg_mail_str.isEmpty())
                {
                    reg_email.setError("Please enter a valid email ID");
                    reg_email.requestFocus();
                }
                else if(reg_adrs_str.isEmpty())
                {
                    getReg_adrs.setError("Please enter your address");
                    getReg_adrs.requestFocus();
                }
                else if(reg_name_str.isEmpty())
                {
                    getReg_name.setError("Please enter your Name");
                    getReg_name.requestFocus();
                }
                else if(reg_phone_str.isEmpty())
                {
                    getReg_phone.setError("Please enter your phone number");
                    getReg_phone.requestFocus();
                }
                else if(reg_pwd_str.isEmpty())
                {
                    reg_psd.setError("Please enter a password");
                    reg_psd.requestFocus();
                }

                else if(!reg_pwd_str.equals(cnf_pwd_str))
                {
                    reg_psd.setError("Passwords do not match");
                    reg_psd.requestFocus();
                    cnf_psd.setError("Passwords do not match");
                    cnf_psd.requestFocus();
                }
                else
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(reg_mail_str, reg_pwd_str)
                            .addOnCompleteListener(RegisterUser.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText( RegisterUser.this,"Sign up:success",Toast.LENGTH_SHORT).show();
                                        //FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                        Intent intent = new Intent(getApplicationContext(),com.example.migration.Register.LoginOrRegister.class);
                                        startActivity(intent);

                                        //go to Home screen
                                    }
                                    else {
                                        Toast.makeText(RegisterUser.this, "Signup failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                    // ...
                                }
                            });
                }
            }
        });

    }
}
