package com.sanghun.CSE535_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button symptom;

    Camera camera;
    FrameLayout frameLayout;
    CameraScreen cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define a button to switch to the next screen
        symptom = findViewById(R.id.symptom);
        symptom.setOnClickListener((v) -> {
            Intent sa = new Intent(MainActivity.this, SubActivity.class);
            startActivity(sa);
        });

        // Define camera preview
        frameLayout = (FrameLayout) findViewById(R.id.cameraFrame);
        camera = Camera.open();
        cs = new CameraScreen(this, camera);
        frameLayout.addView(cs);
    }
}