package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class Wifi extends AppCompatActivity {
    Button b1;
    ToggleButton tb;
    WifiManager w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        tb = (ToggleButton)findViewById(R.id.toggleButton);
        b1 = (Button) findViewById(R.id.button27);
        w1 = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    w1.setWifiEnabled(true);
                }
                else{
                    w1.setWifiEnabled(false);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Wifi.this, Homepage.class);
                startActivity(j);
                finish();
            }
        });
    }
}