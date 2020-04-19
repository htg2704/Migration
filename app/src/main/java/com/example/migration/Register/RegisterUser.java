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

        mFirebaseAuth=FirebaseAuth.getInstance();


        reg_sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reg_mail_str=reg_email.getText().toString();
                String reg_pwd_str=reg_psd.getText().toString();
                if(reg_mail_str.isEmpty())
                {
                    reg_email.setError("Please enter a valid email ID");
                    reg_email.requestFocus();
                }
                else if(reg_pwd_str.isEmpty())
                {
                    reg_psd.setError("Please enter a password");
                    reg_psd.requestFocus();
                }
                else
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(reg_mail_str, reg_pwd_str)
                            .addOnCompleteListener(RegisterUser.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText( RegisterUser.this,"Signup:success",Toast.LENGTH_SHORT).show();
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
