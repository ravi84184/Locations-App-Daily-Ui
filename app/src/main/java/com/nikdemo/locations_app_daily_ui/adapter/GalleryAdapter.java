package com.nikdemo.locations_app_daily_ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nikdemo.locations_app_daily_ui.FeedDeatilActivity;
import com.nikdemo.locations_app_daily_ui.R;
import com.nikdemo.locations_app_daily_ui.Utils;
import com.nikdemo.locations_app_daily_ui.model.FeedModel;

import java.io.Serializable;
import java.util.ArrayList;


public class GalleryAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Integer> list;

    int selectedItem = 0;

    public GalleryAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_gallery_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;

        holder.txt_count.setText(String.valueOf(list.size()));

        holder.feed_img.setImageDrawable(ContextCompat.getDrawable(context,list.get(position)));

        if (list.size() > 4){
            if (position == 3){
                holder.rl_count.setVisibility(View.VISIBLE);
                holder.txt_count.setText("+"+String.valueOf(list.size()-1-position));
            } else {
                holder.rl_count.setVisibility(View.GONE);
            }
        } else {
            holder.rl_count.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        if (list.size() > 4){
            return 4;
        } else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_count;
        ImageView feed_img;
        RelativeLayout rl_count;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_count = itemView.findViewById(R.id.txt_count);
            feed_img = itemView.findViewById(R.id.feed_img);
            rl_count = itemView.findViewById(R.id.rl_count);

        }
    }
}
