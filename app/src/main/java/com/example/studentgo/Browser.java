package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity {
    EditText e1;
    WebView w1;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName5);
        b1 = (Button) findViewById(R.id.button21);
        b2 = (Button) findViewById(R.id.button22);
        w1 = (WebView) findViewById(R.id.webView);
        w1.setWebViewClient(new WebViewClient());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString().trim();
                w1.loadUrl(s1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Browser.this, Homepage.class);
                startActivity(i);
                finish();
            }
        });
    }
}