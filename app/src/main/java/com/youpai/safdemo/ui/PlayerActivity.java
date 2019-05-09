package com.youpai.safdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.youpai.safdemo.R;

public class PlayerActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Uri uri = getIntent().getParcelableExtra("uri");

        mVideoView = findViewById(R.id.video_view);
        mVideoView.setVideoURI(uri);
        mVideoView.start();
    }


    public static void open(Context context, Uri uri) {
        Intent intent = new Intent(context, PlayerActivity.class);
        intent.putExtra("uri", uri);
        context.startActivity(intent);
    }
}
