package com.example.marvelapp.fragments.data;

import com.example.marvelapp.R;
import com.example.marvelapp.fragments.data.models.HomeModel;

import java.util.ArrayList;

public class HomeData {
    public static ArrayList<HomeModel> list = new ArrayList<>();

    public static ArrayList<HomeModel> getList() {
        list.add(new HomeModel(R.drawable.avengers, "Avengers"));
        list.add(new HomeModel(R.drawable.x_men, "X-Men"));
        list.add(new HomeModel(R.drawable.fantastic_four, "Fantastic Four"));
        list.add(new HomeModel(R.drawable.blade, "Blade"));

        return list;
    }
}
