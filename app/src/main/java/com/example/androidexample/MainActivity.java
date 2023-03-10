package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.androidexample.executor.ExecutorActivity;
import com.example.androidexample.rx.SecondActivity;
import com.example.androidexample.video_to_gif.VideoToGifActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRx = findViewById(R.id.btn_rx);
        Button btnExecutor = findViewById(R.id.btn_executor);
        Button btnVideoToGif = findViewById(R.id.btn_video_to_gif);

        btnRx.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        });

        btnExecutor.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ExecutorActivity.class));
        });

        btnVideoToGif.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, VideoToGifActivity.class));
        });

    }

}
