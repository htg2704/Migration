package com.example.migration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class SliderActivity extends AppCompatActivity {


    private long backPressedTime = 0;
    SliderLayout sliderLayout;
    LinearLayout welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

            welcome = (LinearLayout) findViewById(R.id.wel);


            welcome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent beach = new  Intent(SliderActivity.this, MainActivity.class);
                    startActivity(beach);
                }
            });



            sliderLayout = findViewById(R.id.imageSlider);
            sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
            sliderLayout.setScrollTimeInSec(2);

            setSliderViews();

        }

        private void setSliderViews() {

            for (int i = 0; i <= 2; i++) {

                DefaultSliderView sliderView = new DefaultSliderView(this);


                switch (i) {
                    case 0:
                        sliderView.setImageUrl("https://i.postimg.cc/3RmgXv3L/s1.png");
                        break;
                    case 1:
                        sliderView.setImageUrl("https://i.postimg.cc/9QNNX0Cx/s2.png");
                        break;
                    case 2:
                        sliderView.setImageUrl("https://i.postimg.cc/DZfnX5Sv/s3.png");
                        break;


                }
                sliderLayout.addSliderView(sliderView);
            }


        }


    @Override
    public void onBackPressed() {
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {
            backPressedTime = t;
            Toast.makeText(this, "Press back again to close ", Toast.LENGTH_SHORT).show();
        } else {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

}

