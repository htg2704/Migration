package com.kutumb.migration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
