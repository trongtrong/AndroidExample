package com.example.androidexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
