package com.youpai.safdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.youpai.safdemo.R;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toVideoList(View view)
    {
        VideoListActivity.open(this);
    }

    public void toPicList(View view)
    {
        PicListActivity.open(this);
    }

    public void toSAF(View view)
    {
        SAFActivity.open(this);
    }
}
