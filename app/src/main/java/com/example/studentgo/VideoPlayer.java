package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    VideoView v1;
    MediaController m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        v1 = (VideoView)findViewById(R.id.videoView);
        m1 = new MediaController(this);
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.a);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
    }
}