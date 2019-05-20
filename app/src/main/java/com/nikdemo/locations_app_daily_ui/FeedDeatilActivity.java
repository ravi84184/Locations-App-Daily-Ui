package com.nikdemo.locations_app_daily_ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikdemo.locations_app_daily_ui.adapter.GalleryAdapter;
import com.nikdemo.locations_app_daily_ui.model.FeedModel;

public class FeedDeatilActivity extends BaseActivity {

    private FeedModel model;

    private RecyclerView rl_gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_deatil);

        model = (FeedModel) getIntent().getSerializableExtra("model");

        intiUI();

    }

    private void intiUI() {

        rl_gallery = findViewById(R.id.rl_gallery);
        rl_gallery.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));

        rl_gallery.setAdapter(new GalleryAdapter(this,model.getImgUrl()));


        ((TextView) findViewById(R.id.feed_title)).setText(model.getTitle());
        ((TextView) findViewById(R.id.feed_subTitle)).setText(model.getSubTitle());
        ((TextView) findViewById(R.id.feed_description)).setText(model.getDescription());
    }
}
