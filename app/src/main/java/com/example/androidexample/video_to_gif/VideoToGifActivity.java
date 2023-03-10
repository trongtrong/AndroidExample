package com.example.androidexample.video_to_gif;

import android.os.Bundle;
import android.os.Environment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidexample.R;
import com.example.androidexample.video_to_gif.gifencoder.GifExtractor;

import java.io.File;

public class VideoToGifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_to_gif);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/HMSDK/test_1535007031957.gif";
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        GifExtractor gifExtractor = new GifExtractor(this, Environment.getExternalStorageDirectory().getAbsolutePath() + "/HMSDK/video/1535007031957.mp4");
        gifExtractor.encoder(path, 0, 10 * 1000, 15, 15, 320, 240);


    }
}
