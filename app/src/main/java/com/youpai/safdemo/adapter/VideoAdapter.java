package com.youpai.safdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youpai.safdemo.R;
import com.youpai.safdemo.entity.Video;

import java.util.List;

/**
 * Created by XuCanHui on 2019-05-08.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ItemViewHolder> {

    private List<Video> mVideoList;

    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Video video = mVideoList.get(i);
        Glide.with(itemViewHolder.thumbView.getContext()).load(video.getUri()).into(itemViewHolder.thumbView);
    }

    @Override
    public int getItemCount() {
        return mVideoList == null ? 0 : mVideoList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView thumbView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbView = itemView.findViewById(R.id.thumb);
            thumbView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                Video video = mVideoList.get(getAdapterPosition());
                mOnItemClickListener.onItemClick(getAdapterPosition(), video);
            }
        }
    }

    public void setVideoList(List<Video> videoList) {
        mVideoList = videoList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position, Video video);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }


}
