package com.example.migration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.migration.Questions.questions;
import com.example.migration.Register.select_login_type;
import com.example.migration.common.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class notifcation extends AppCompatActivity {


    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifcation);


        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notifcation.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
    @Override
    public void onBackPressed() {

                        finish();
                        Intent intent = new Intent(notifcation.this, MainActivity.class);
                        startActivity(intent);

    }
}
