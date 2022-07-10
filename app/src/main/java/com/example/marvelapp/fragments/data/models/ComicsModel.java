package com.example.marvelapp.fragments.data.models;

public class ComicsModel {
    private Integer imageComics;
    private String nameComics;

    public ComicsModel(Integer imageComics, String nameComics) {
        this.imageComics = imageComics;
        this.nameComics = nameComics;
    }

    public Integer getImageComics() {
        return imageComics;
    }

    public String getNameComics() {
        return nameComics;
    }
}
