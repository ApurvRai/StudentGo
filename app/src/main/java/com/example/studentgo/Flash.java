package com.example.studentgo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Flash extends AppCompatActivity {
    private ImageButton ib;
    Button b1;
    boolean hasFlash=false;
    boolean flashOn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        ib = (ImageButton) findViewById(R.id.imageButton11);
        b1 = (Button) findViewById(R.id.button12);
        hasFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        ib.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
            if(hasFlash){
                if (flashOn){
                    flashOn = false;
                    ib.setImageResource(R.drawable.off);
                    try {
                        flashLightOff();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    flashOn=true;
                    ib.setImageResource(R.drawable.on);
                    try {
                        flashLightOn();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                Toast.makeText(Flash.this, "Flash not supported.", Toast.LENGTH_SHORT).show();
            }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Flash.this, Homepage.class);
                startActivity(i);
                finish();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flashLightOn() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraId, true);

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flashLightOff() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraId, false);

    }
}