package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class Bluetooth extends AppCompatActivity {
    ToggleButton tb;
    BluetoothAdapter ba;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        tb = (ToggleButton)findViewById(R.id.toggleButton2);
        b1 = (Button) findViewById(R.id.button13);
        ba = BluetoothAdapter.getDefaultAdapter();
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ba.enable();
                }
                else {
                    ba.disable();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bluetooth.this, Homepage.class);
                startActivity(i);
                finish();
            }
        });
    }
}