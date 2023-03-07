package com.example.androidexample.executor;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidexample.R;
import com.example.androidexample.util.Utils;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorActivity extends AppCompatActivity {
    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executor);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<String> videoList = Utils.getAllMedia(getApplicationContext());
                    for (int i = 0; i < videoList.size(); i++) {
                        Log.d("ExecutorActivity", " name ==  : " + videoList.get(i));
                    }

                    runOnUiThread(() -> {
                        // Xử lý danh sách video ở đây
                    });

                } catch (Exception e) {
                    runOnUiThread(() -> {
                        //xủ lý lỗi ở đây
                    });

                }
            }
        });


    }
}
