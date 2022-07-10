package com.example.marvelapp.fragments.data;

import com.example.marvelapp.R;
import com.example.marvelapp.fragments.data.models.MarketModel;

import java.util.ArrayList;

public class MarketData {
    public static ArrayList<MarketModel> list  = new ArrayList<>();

    public static ArrayList<MarketModel> getList() {
        list.add(new MarketModel(R.drawable.avengers2019, "AVENGERS\n#12 (2019) ", "Price: $4.99"));
        list.add(new MarketModel(R.drawable.star_wars, "STAR WARS\n #59 (2019)", "Price: $4.99"));
        list.add(new MarketModel(R.drawable.ant_man, "Ant-Man & the \nWasp (2018) #3","Price: $4.99"));
        list.add(new MarketModel(R.drawable.captain_america, "Captain America \n(2018) #12", "Price: $4.99"));
        list.add(new MarketModel(R.drawable.x_men_red, "X-Men Red\n (2018) #101", "Price: $4.99"));
        list.add(new MarketModel(R.drawable.venom_comics, "Venom First \nHost (2018) #1", "Price: $4.99"));

        return list;
    }
}
