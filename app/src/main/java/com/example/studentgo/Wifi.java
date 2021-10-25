package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class Wifi extends AppCompatActivity {
    ToggleButton tb;
    WifiManager w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        tb = (ToggleButton)findViewById(R.id.toggleButton);
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
    }
}