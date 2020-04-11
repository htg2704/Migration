package com.example.migration.Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.migration.R;
import com.example.migration.common.User;

public class select_login_type extends AppCompatActivity {

    Button btn_volunteer, btn_mobiliser, btn_agency;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_type);


        User.type=0;

        btn_mobiliser=findViewById(R.id.btn_cmob);
        btn_volunteer=findViewById(R.id.log_mail);
        btn_agency=findViewById(R.id.btn_ngo);


        btn_volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.type=1;

                Intent intent = new Intent(getApplicationContext(),com.example.migration.data.data_main.class);
                startActivity(intent);

            }
        });
        btn_mobiliser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.type=2;
                Intent intent = new Intent(getApplicationContext(),com.example.migration.data.data_main.class);
                startActivity(intent);
            }
        });
        btn_agency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.type=3;
                Intent intent = new Intent(getApplicationContext(),com.example.migration.Register.select_login_type.class);
                startActivity(intent);
            }
        });
    }
}
