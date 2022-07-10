package com.example.marvelapp.fragments.data.models;

public class HomeModel {
    private Integer imageHome;
    private String nameHome;

    public HomeModel(Integer imageHome, String nameHome) {
        this.imageHome = imageHome;
        this.nameHome = nameHome;
    }

    public Integer getImageHome() {
        return imageHome;
    }

    public String getNameHome() {
        return nameHome;
    }
}
