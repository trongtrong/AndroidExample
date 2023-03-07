package com.example.androidexample.rx;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.androidexample.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class VideoListObservable {
    private static volatile VideoListObservable instance;

    private final Observable<List<String>> videoListObservable;

    public static VideoListObservable getInstance(Context context) {
        if (instance == null) {
            synchronized (VideoListObservable.class) {
                if (instance == null) {
                    instance = new VideoListObservable(context);
                }
            }
        }
        return instance;
    }

    public Observable<List<String>> getVideoListObservable() {
        return videoListObservable;
    }


    private VideoListObservable (Context context) {
        videoListObservable =  Observable.create(emitter -> {
            List<String> videoList = new ArrayList<>();
            // Lấy danh sách video từ device
            videoList.addAll(Utils.getAllMedia(context));
            // Phát ra danh sách video
            emitter.onNext(videoList);
            // Kết thúc Observable
            emitter.onComplete();
        });
    }

}
