package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPlayer extends AppCompatActivity {
    Button b1, b2, b3;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        b1 = (Button)findViewById(R.id.button19);
        b2 = (Button)findViewById(R.id.button20);
        b3 = (Button)findViewById(R.id.button23);
        mp = MediaPlayer.create(this, R.raw.y);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MusicPlayer.this, Homepage.class);
                startActivity(i);
                finish();
            }
        });
    }
}