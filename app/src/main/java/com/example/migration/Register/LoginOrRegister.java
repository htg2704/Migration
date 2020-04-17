package com.example.migration.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.migration.Questions.questions;
import com.example.migration.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginOrRegister extends AppCompatActivity {
    EditText log_email;
    EditText log_psd;

    Button log_sgnin;
    FirebaseAuth mFirebaseAuth;
    TextView tvr;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        log_email=findViewById(R.id.log_mail);
        log_psd=findViewById(R.id.log_pwd);
        log_sgnin=findViewById(R.id.btn_login);
        tvr=findViewById(R.id.tv_reg);
        mFirebaseAuth= FirebaseAuth.getInstance();
        //mAuthListener=new FirebaseAuth.AuthStateListener() {
            //@Override
          //  public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=mFirebaseAuth.getCurrentUser();

                if(firebaseUser!=null)
                {
                    Toast.makeText(LoginOrRegister.this,"You are Logged In",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), questions.class);
                    startActivity(intent);

                    //Intent switching to Home Screen;
                }
                else
                {
                    Toast.makeText(LoginOrRegister.this,"You are'nt Logged In",Toast.LENGTH_SHORT).show();
                    //Intent switching to Log In Screen;
                }
            //}
        //};

        tvr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterUser.class);
                startActivity(intent);
            }
        });
        log_sgnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String reg_mail_str=log_email.getText().toString();
                String reg_pwd_str=log_psd.getText().toString();
                if(reg_mail_str.isEmpty())
                {
                    log_email.setError("Please enter a valid email ID");
                    log_email.requestFocus();
                }
                else if(reg_pwd_str.isEmpty())
                {
                    log_psd.setError("Please enter a password");
                    log_psd.requestFocus();
                }
                else
                {
                    mFirebaseAuth.signInWithEmailAndPassword(reg_mail_str, reg_pwd_str)
                            .addOnCompleteListener(LoginOrRegister.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText( LoginOrRegister.this,"LogIn:success",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), questions.class);
                                        startActivity(intent);
                                        //FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                        //go to Home screen
                                    } else {
                                        Toast.makeText(LoginOrRegister.this, "LogIn failed.",
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
/*



 */