package com.example.buildingcommittee.Data;

import com.google.gson.annotations.SerializedName;

public class Post {
    int userId;
    int id;
    String title;
    @SerializedName("body")
    String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
