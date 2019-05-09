package com.youpai.safdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.youpai.safdemo.R;
import com.youpai.safdemo.adapter.VideoAdapter;
import com.youpai.safdemo.entity.Video;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends AppCompatActivity
{
    private RecyclerView mRecyclerView;

    private VideoAdapter mVideoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        mVideoAdapter = new VideoAdapter();

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mVideoAdapter);

        mVideoAdapter.setOnItemClickListener(new VideoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Video video) {
                PlayerActivity.open(VideoListActivity.this, video.getUri());
            }
        });


        loadVideoList();
    }

    public static void open(Context context)
    {
        Intent intent = new Intent(context, VideoListActivity.class);
        context.startActivity(intent);
    }

    private void loadVideoList() {
        List<Video> videoList = new ArrayList<>();
        Cursor cursor = getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Video.Media._ID},
                null, null, null);
        while (cursor.moveToNext()) {
            Video video = new Video();
            int id = cursor.getInt(cursor.getColumnIndex(MediaStore.Video.Media._ID));
            Uri videoUri = Uri.parse(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString() + File.separator + id);
            video.setUri(videoUri);
            Log.i("asdf", "videoUri:" + videoUri);
            videoList.add(video);
        }
        mVideoAdapter.setVideoList(videoList);
        Log.i("asdf", "video size:" + cursor.getCount());

    }
}
