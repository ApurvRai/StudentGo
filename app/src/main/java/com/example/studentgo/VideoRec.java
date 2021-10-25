package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoRec extends AppCompatActivity {
    Button b1;
    VideoView v1;
    MediaController m1;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_rec);
        b1 = (Button)findViewById(R.id.button16);
        v1 = (VideoView)findViewById(R.id.videoView3);
        m1 = new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i, 10);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri = data.getData();
        v1.setVideoURI(uri);
        v1.setMediaController(m1);
        m1.setAnchorView(v1);
        v1.start();
    }
}