package com.example.androidexample;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

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
            videoList.addAll(getAllMedia(context));
            // Phát ra danh sách video
            emitter.onNext(videoList);
            // Kết thúc Observable
            emitter.onComplete();
        });
    }

    public ArrayList<String> getAllMedia(Context context) {
        HashSet<String> videoItemHashSet = new HashSet<>();
        String[] projection = {MediaStore.Video.VideoColumns.DATA, MediaStore.Video.Media.DISPLAY_NAME};
        Cursor cursor = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        try {
            cursor.moveToFirst();
            do {
                videoItemHashSet.add((cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))));
            } while (cursor.moveToNext());

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> downloadedList = new ArrayList<>(videoItemHashSet);
        return downloadedList;
    }

}
