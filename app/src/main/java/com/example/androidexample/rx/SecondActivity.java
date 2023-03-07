package com.example.androidexample.rx;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidexample.R;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SecondActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//
        Disposable disposable = VideoListObservable.getInstance(this).getVideoListObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(videoList -> {
                    for (int i = 0; i < videoList.size(); i++) {
                        Log.d("SecondActivity", "subscribe: " + videoList.get(i));
                    }
                }, throwable -> {
                    Log.d("SecondActivity", "throwable: ");
                });

    }
}
