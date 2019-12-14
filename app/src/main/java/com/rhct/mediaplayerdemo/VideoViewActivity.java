package com.rhct.mediaplayerdemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.Timer;
import java.util.TimerTask;

//这种方式在NME100盒子上黑屏显示。
public class VideoViewActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private static final String TAG = "VideoViewActivity";
    private VideoView video_view;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        video_view = (VideoView) findViewById(R.id.video_view);
        video_view.setOnCompletionListener(this);
        video_view.setMediaController(new MediaController(this));
        video_view.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        video_view.start();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d(TAG, "video_view.isPlaying():"+video_view.isPlaying());
            }
        },1000, 5000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        video_view.stopPlayback();
        timer.cancel();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.start();
    }
}
