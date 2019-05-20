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
import android.widget.TextView;

import com.nikdemo.locations_app_daily_ui.FeedDeatilActivity;
import com.nikdemo.locations_app_daily_ui.model.FeedModel;
import com.nikdemo.locations_app_daily_ui.R;
import com.nikdemo.locations_app_daily_ui.Utils;

import java.io.Serializable;
import java.util.ArrayList;


public class FeedAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<FeedModel> list;

    int selectedItem = 0;

    public FeedAdapter(Context context, ArrayList<FeedModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_feed_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        FeedModel model = list.get(position);

        holder.feed_title.setText(model.getTitle());
        holder.feed_description.setText(model.getSubTitle());

        String text = "<font color=#000000>"+ Utils.changeDatePattern(model.getDate(),"dd")+"</font>" +
                "<br/> <font> "+Utils.changeDatePattern(model.getDate(),"MMM")+" </font>";

        holder.feed_date.setText(Html.fromHtml(text));

        holder.feed_img.setImageDrawable(ContextCompat.getDrawable(context, model.getImgUrl().get(0)));

        holder.ll_main.setOnClickListener(v->{
            context.startActivity(new Intent(context, FeedDeatilActivity.class).putExtra("model",(Serializable) model));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView feed_title,feed_description,feed_date;
        ImageView feed_img;
        LinearLayout ll_main;
        public MyViewHolder(View itemView) {
            super(itemView);
            ll_main = itemView.findViewById(R.id.ll_main);
            feed_title = itemView.findViewById(R.id.feed_title);
            feed_description = itemView.findViewById(R.id.feed_description);
            feed_date = itemView.findViewById(R.id.feed_date);
            feed_img = itemView.findViewById(R.id.feed_img);

        }
    }
}
