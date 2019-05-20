package com.nikdemo.locations_app_daily_ui;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.LinearLayout;

import com.nikdemo.locations_app_daily_ui.adapter.FeedAdapter;
import com.nikdemo.locations_app_daily_ui.adapter.MenuAdapter;
import com.nikdemo.locations_app_daily_ui.model.FeedModel;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends BaseActivity {


    RecyclerView rl_menu,rl_feed;
    MenuAdapter menuAdapter;
    FeedAdapter feedAdapter;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<FeedModel> feedList = new ArrayList<>();
    int[] imgList = {R.drawable.d,R.drawable.e,R.drawable.f};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initUI() {
        rl_menu = findViewById(R.id.rl_menu);
        rl_menu.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));

        rl_feed = findViewById(R.id.rl_feed);
        rl_feed.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));

        list.add("Featured");
        list.add("Popular");
        list.add("Trending");

        feedList.add(new FeedModel(
                "Ocean at Algarve",
                "Enjoy view over sky blue ocean from your room",
                "This character description generator will generate a fairly random description of a belonging to a random race. However, some aspects of the descriptions will remain the same, this is done to keep the general structure the same, while still randomizing the important details.",
                "29/08/2019",
                getImage(10)
        ));

        feedList.add(new FeedModel(
                "Antelope Canyon",
                "Must have on a bucket list beacuse it's awesome",
                "I've made the descriptions as detailed as possible, while also withholding as many details as possible. This may sound odd, but I've done it by mostly describing how a character looks, rather than his or her personality. I've tried to make the character's looks and some vague personality traits dictate what kind of person he or she could be.",
                "25/04/2019",
                getImage(8)
        ));

        feedList.add(new FeedModel(
                "Ocean at Algarve",
                "Enjoy view over sky blue ocean from your room",
                "You're free to use names on this site to name anything in any of your own works, assuming they aren't already trademarked by others of course." +
                        "All background images part of the generators are part of the public domain and thus free to be used by anybody," +
                        "with the exception of user submitted backgrounds, images part of existing, copyrighted works, and the pet name generator images.",
                "22/01/2019",
                getImage(5)
        ));


        feedAdapter = new FeedAdapter(this,feedList);
        rl_feed.setAdapter(feedAdapter);

        menuAdapter = new MenuAdapter(this,list);
        rl_menu.setAdapter(menuAdapter);

    }

    private ArrayList<Integer> getImage(int size){
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i =0;i<size;i++){
            list.add(imgList[rand.nextInt(imgList.length)]);
        }

        return list;
    }

}
