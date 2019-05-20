package com.nikdemo.locations_app_daily_ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nikdemo.locations_app_daily_ui.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MenuAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> list;

    int selectedItem = 0;

    public MenuAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_menu_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.txt_menu.setText(list.get(position));

        if (selectedItem == position){
            holder.view_selected.setVisibility(View.VISIBLE);
            holder.txt_menu.setTextColor(ContextCompat.getColor(context,R.color.blue));
        } else {
            holder.view_selected.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setNewData(ArrayList<String> searchResult) {
        list = searchResult;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_menu;
        View view_selected;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_menu = itemView.findViewById(R.id.txt_menu);
            view_selected = itemView.findViewById(R.id.view_selected);

        }
    }
}
