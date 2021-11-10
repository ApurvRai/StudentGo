package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {
    Button b1;
    ImageButton i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        b1 = (Button) findViewById(R.id.b4);
        i1 = (ImageButton) findViewById(R.id.imageButton);
        i2 = (ImageButton) findViewById(R.id.imageButton2);
        i3 = (ImageButton) findViewById(R.id.imageButton3);
        i4 = (ImageButton) findViewById(R.id.imageButton4);
        i5 = (ImageButton) findViewById(R.id.imageButton5);
        i6 = (ImageButton) findViewById(R.id.imageButton6);
        i7 = (ImageButton) findViewById(R.id.imageButton7);
        i8 = (ImageButton) findViewById(R.id.imageButton8);
        i9 = (ImageButton) findViewById(R.id.imageButton9);
        i10 = (ImageButton) findViewById(R.id.imageButton10);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homepage.this, Calculator.class);
                startActivity(i);
                finish();
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Homepage.this, Flash.class);
                startActivity(j);
                finish();
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(Homepage.this, Bluetooth.class);
                startActivity(k);
                finish();
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(Homepage.this, Camera.class);
                startActivity(l);
                finish();
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(Homepage.this, VideoRec.class);
                startActivity(m);
                finish();
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(Homepage.this, VideoPlayer.class);
                startActivity(n);
                finish();
            }
        });

        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(Homepage.this, Wifi.class);
                startActivity(o);
                finish();
            }
        });

        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(Homepage.this, Vibrate.class);
                startActivity(p);
                finish();
            }
        });

        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(Homepage.this, MusicPlayer.class);
                startActivity(q);
                finish();
            }
        });

        i10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(Homepage.this, Browser.class);
                startActivity(r);
                finish();
            }
        });
        googleSignInClient = GoogleSignIn.getClient(Homepage.this, GoogleSignInOptions.DEFAULT_SIGN_IN);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent s = new Intent(Homepage.this, MainActivity.class);
                startActivity(s);
                finish();*/
                googleSignInClient.signOut();
                FirebaseAuth.getInstance().signOut();
                Intent s = new Intent(Homepage.this, MainActivity.class);
                startActivity(s);
                finish();
            }
        });
    }
}