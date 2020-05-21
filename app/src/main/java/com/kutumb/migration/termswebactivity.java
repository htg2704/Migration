package com.kutumb.migration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class termswebactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termswebactivity);
        final WebView web=(WebView)findViewById(R.id.web);

        WebSettings setting=web.getSettings();
        setting.setJavaScriptEnabled(true);
        web.loadUrl("https://firebasestorage.googleapis.com/v0/b/kutumb-migration.appspot.com/o/policies%2Fterms.html?alt=media&token=88997647-396c-4d50-ab15-01d8d7e230f6");


    }
}
