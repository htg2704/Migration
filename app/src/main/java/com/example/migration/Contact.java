package com.example.migration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Contact extends AppCompatActivity {

    ImageButton logout;
    Button call,mail,faq,terms,privacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        logout=findViewById(R.id.btn_logout);
        call=findViewById(R.id.call);
        mail=findViewById(R.id.mail);
        faq = findViewById(R.id.faq);
        terms = findViewById(R.id.terms);
        privacy = findViewById(R.id.privacy);



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mobileIntent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +919853939599"));
                startActivity(Intent.createChooser(mobileIntent, "Select dialer..."));
            }
        });


        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                String[] TO={"kutumbmigrationhelp@gmail.com"};
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,TO );
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Kutmub");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, privacywebactivity.class);
                startActivity(intent);

            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://www.kutumbindia.com/"));
                startActivity(browserIntent);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, termswebactivity.class);
                startActivity(intent);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contact.this, MainActivity.class);
                startActivity(intent);

            }
        });



    }


    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(Contact.this, MainActivity.class);
        startActivity(intent);
    }
}
