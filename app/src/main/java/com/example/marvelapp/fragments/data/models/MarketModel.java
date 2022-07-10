package com.example.marvelapp.fragments.data.models;

public class MarketModel {
    private Integer imageMarket;
    private String nameComicsMarket;
    private String priceMarket;

    public MarketModel(Integer imageMarket, String nameComicsMarket, String priceMarket) {
        this.imageMarket = imageMarket;
        this.nameComicsMarket = nameComicsMarket;
        this.priceMarket = priceMarket;
    }

    public Integer getImageMarket() {
        return imageMarket;
    }

    public String getNameComicsMarket() {
        return nameComicsMarket;
    }

    public String getPriceMarket() {
        return priceMarket;
    }
}
