package com.kutumb.migration.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.kutumb.migration.R;

public class MobileAuth extends AppCompatActivity {

    EditText mobileno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_auth);

        mobileno = findViewById(R.id.editTextMobAuth);
        findViewById(R.id.btnMobAuth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String mobile = mobileno.getText().toString().trim();

        if(mobile.isEmpty() || mobile.length() < 10){
            mobileno.setError("Enter a valid mobile");
            mobileno.requestFocus();
            return;
        }

        Intent intent = new Intent(getApplicationContext(),VerifyMobile.class);
        intent.putExtra("mobile",mobile);
        startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(MobileAuth.this, LoginOrRegister.class);
        startActivity(intent);
    }
}
