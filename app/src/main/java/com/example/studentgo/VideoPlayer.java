package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    Button b1;
    VideoView v1;
    MediaController m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        b1 = (Button) findViewById(R.id.button25);
        v1 = (VideoView)findViewById(R.id.videoView);
        m1 = new MediaController(this);
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.a);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VideoPlayer.this, Homepage.class);
                startActivity(i);
                finish();
            }
        });
    }
}