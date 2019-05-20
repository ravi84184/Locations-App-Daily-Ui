package com.nikdemo.locations_app_daily_ui.model;

import java.io.Serializable;
import java.util.ArrayList;

public class FeedModel implements Serializable {

    String title,subTitle,description,date;
    ArrayList<Integer> imgUrl;


    public FeedModel(String title, String subTitle, String description, String date, ArrayList<Integer> imgUrl) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.date = date;
        this.imgUrl = imgUrl;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Integer> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(ArrayList<Integer> imgUrl) {
        this.imgUrl = imgUrl;
    }
}
