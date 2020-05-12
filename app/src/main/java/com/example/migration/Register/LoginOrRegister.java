package com.example.migration.Register;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.migration.Questions.questions;
import com.example.migration.R;
import com.example.migration.after_login;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginOrRegister extends AppCompatActivity {
    private static final int RC_SIGN_IN =007 ;
    EditText log_email;
    EditText log_psd;

    Button log_sgnin;
    FirebaseAuth mFirebaseAuth;
    TextView tvr;
    TextView tvfp;
    ImageView mobileauth;
    Button drawable;
    CallbackManager callbackManager;
    private Boolean isClicked = false;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        log_email=findViewById(R.id.log_mail);
        log_psd=findViewById(R.id.log_pwd);
        log_sgnin=findViewById(R.id.btn_login);
        tvr=findViewById(R.id.tv_reg);
        mobileauth = findViewById(R.id.mobauth);
        tvfp = findViewById(R.id.tv_forgotpass);
        mFirebaseAuth= FirebaseAuth.getInstance();
        drawable=findViewById(R.id.draw);

        drawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked = isClicked ? false : true;
                if (isClicked) {
                    log_psd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    log_psd.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });
                FirebaseUser firebaseUser=mFirebaseAuth.getCurrentUser();

                if(firebaseUser!=null && firebaseUser.isEmailVerified())
                {
                    Toast.makeText(LoginOrRegister.this,"You are Logged In",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), after_login.class);
                    startActivity(intent);

                    //Intent switching to Home Screen;
                }
                else
                {
                    Toast.makeText(LoginOrRegister.this,"You aren't Logged In",Toast.LENGTH_SHORT).show();
                    //Intent switching to Log In Screen;
                }

        tvr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(LoginOrRegister.this);
                LayoutInflater factory = LayoutInflater.from(LoginOrRegister.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(), RegisterUser.class);
                        startActivity(intent);
                    }
                }, 1200);


            }
        });
        tvfp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(LoginOrRegister.this);
                LayoutInflater factory = LayoutInflater.from(LoginOrRegister.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(), ForgotPass.class);
                        startActivity(intent);
                    }
                }, 1200);


            }
        });
        mobileauth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(LoginOrRegister.this);
                LayoutInflater factory = LayoutInflater.from(LoginOrRegister.this);
                view = factory.inflate(R.layout.sample, null);
                alertadd.setView(view);
                alertadd.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(), MobileAuth.class);
                        startActivity(intent);
                    }
                }, 1200);


            }
        });

        log_sgnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String reg_mail_str=log_email.getText().toString();
                String reg_pwd_str=log_psd.getText().toString();
                if (reg_mail_str.isEmpty())
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

                                        if(mFirebaseAuth.getCurrentUser().isEmailVerified())
                                        {
                                            // Sign in success, update UI with the signed-in user's information

                                            Toast.makeText( LoginOrRegister.this,"LogIn:success",Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), after_login.class);
                                            startActivity(intent);

                                            //FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                            //go to Home screen
                                        }
                                     else {
                                        Toast.makeText(LoginOrRegister.this, "LogIn failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }}
                                    // ...
                                }
                            });

                }
            }
        });

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton=findViewById(R.id.fb_login_button);

        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Toast.makeText(LoginOrRegister.this,"FB Login Successful",Toast.LENGTH_SHORT).show();
                        handleFBToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(LoginOrRegister.this,"FB Login Unsuccessful",Toast.LENGTH_SHORT).show();
                    }


                });

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                        requestIdToken(getString(R.string.default_g_web_client_id))
                        .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

// Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null)
        {

                mGoogleSignInClient.signOut()
                        .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
                                // ...
                                Toast.makeText(LoginOrRegister.this,"Google Signed Out",Toast.LENGTH_LONG);
                            }
                        });


           // firebaseAuthWithGoogle(account.getIdToken());
        }
        //updateUI(account);
        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.g_sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);

            }
        });
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            Toast.makeText(LoginOrRegister.this, "Firebase GoogleSignIn success",
                                    Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), after_login.class);
                            startActivity(intent);

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                           // Log.w(TAG, "signInWithCredential:failure", task.getException());
                            //Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();

                            Toast.makeText(LoginOrRegister.this, "Firebase GoogleSignIn Failed",
                                    Toast.LENGTH_LONG).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void handleFBToken(AccessToken token)
    {
        AuthCredential credential= FacebookAuthProvider.getCredential(token.getToken());
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginOrRegister.this, "Authentication success.",
                                    Toast.LENGTH_LONG).show();
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            //txtv2.setText(user.getDisplayName());

                            Intent intent = new Intent(getApplicationContext(),after_login.class);
                            startActivity(intent);


                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginOrRegister.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);
            }
         else
            // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Toast.makeText(LoginOrRegister.this, "GoogleSignIn success",
                    Toast.LENGTH_LONG).show();
            firebaseAuthWithGoogle(account.getIdToken());

            // Signed in successfully, show authenticated UI.
            //updateUI(account);
        } catch (ApiException e) {
            Toast.makeText(LoginOrRegister.this, ("GoogleSignIn Failed new "+ e.getStatusCode()),
                    Toast.LENGTH_LONG).show();
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }



    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(LoginOrRegister.this, select_login_type.class);
        startActivity(intent);
    }
}
