package com.youpai.safdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PicListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_list);

    }

    public static void open(Context context)
    {
        Intent intent = new Intent(context, PicListActivity.class);
        context.startActivity(intent);
    }
}
