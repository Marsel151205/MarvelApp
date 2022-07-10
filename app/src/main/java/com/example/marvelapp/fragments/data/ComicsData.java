package com.example.marvelapp.fragments.data;

import com.example.marvelapp.R;
import com.example.marvelapp.fragments.data.models.ComicsModel;

import java.util.ArrayList;

public class ComicsData {

    public static ArrayList<ComicsModel> list = new ArrayList<>();

    public static ArrayList<ComicsModel> getList() {
        list.add(new ComicsModel(R.drawable.ant_man, "Ant-Man & the \nWasp (2018) #3"));
        list.add(new ComicsModel(R.drawable.venom_comics, "Venom First \nHost (2018) #1"));
        list.add(new ComicsModel(R.drawable.x_men_red, "X-Men Red\n(2018) #101"));
        list.add(new ComicsModel(R.drawable.captain_america, "Captain America \n(2018) #12"));
        list.add(new ComicsModel(R.drawable.avengers2019, "AVENGERS\n#12 (2019) "));
        list.add(new ComicsModel(R.drawable.star_wars, "STAR WARS\n #59 (2019)"));

        return list;
    }
}
