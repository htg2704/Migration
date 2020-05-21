package com.kutumb.migration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class meal_activity extends AppCompatActivity {

    ImageButton btn;
    CardView state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_activity);

        state = (CardView)findViewById(R.id.state);
        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(meal_activity.this, meal_provider.class);
                startActivity(intent);
            }
        });



        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(meal_activity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(meal_activity.this, MainActivity.class);
        startActivity(intent);

    }
}
