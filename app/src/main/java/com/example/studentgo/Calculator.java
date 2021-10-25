package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Calculator extends AppCompatActivity {
        Button b1, b2, b3, b4, b5;
        EditText e1,e2;
        TextView t1;
        TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
            b1 = (Button)findViewById(R.id.button7);
            b2 = (Button)findViewById(R.id.button8);
            b3 = (Button)findViewById(R.id.button9);
            b4 = (Button)findViewById(R.id.button10);
            b5 = (Button)findViewById(R.id.button11);
            e1 = (EditText)findViewById(R.id.editTextTextPersonName3);
            e2 = (EditText)findViewById(R.id.editTextTextPersonName4);
            t1 = (TextView)findViewById(R.id.textView5);
            ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                            ts.setLanguage(Locale.ENGLISH);
                            ts.setSpeechRate(1.0f);
                    }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            String s1 = e1.getText().toString();
                            String s2 = e2.getText().toString();
                            Float f1 = Float.parseFloat(s1);
                            Float f2 = Float.parseFloat(s2);
                            Float f3 = f1 + f2;
                            String s3 = Float.toString(f3);
                            t1.setText(s3);
                            ts.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            String s1 = e1.getText().toString();
                            String s2 = e2.getText().toString();
                            Float f1 = Float.parseFloat(s1);
                            Float f2 = Float.parseFloat(s2);
                            Float f3 = f1 - f2;
                            String s3 = Float.toString(f3);
                            t1.setText(s3);
                            ts.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            String s1 = e1.getText().toString();
                            String s2 = e2.getText().toString();
                            Float f1 = Float.parseFloat(s1);
                            Float f2 = Float.parseFloat(s2);
                            Float f3 = f1 * f2;
                            String s3 = Float.toString(f3);
                            t1.setText(s3);
                            ts.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            String s1 = e1.getText().toString();
                            String s2 = e2.getText().toString();
                            Float f1 = Float.parseFloat(s1);
                            Float f2 = Float.parseFloat(s2);
                            Float f3 = f1 / f2;
                            String s3 = Float.toString(f3);
                            t1.setText(s3);
                            ts.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            Intent i = new Intent(Calculator.this, Homepage.class);
                            startActivity(i);
                            finish();
                    }
            });
    }
}