package com.kutumb.migration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class privacywebactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacywebactivity);
        final WebView web=(WebView)findViewById(R.id.web);

        WebSettings setting=web.getSettings();
        setting.setJavaScriptEnabled(true);
        web.loadUrl("https://firebasestorage.googleapis.com/v0/b/kutumb-migration.appspot.com/o/policies%2Fprivacy.html?alt=media&token=e5279a00-2431-4bdc-bc21-1e48eb72b1f5");


    }
}
