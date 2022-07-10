package com.example.marvelapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marvelapp.R;
import com.example.marvelapp.adapters.ComicsAdapter;
import com.example.marvelapp.fragments.data.ComicsData;
import com.example.marvelapp.fragments.data.models.ComicsModel;

import java.util.ArrayList;


public class ComicsMarket extends Fragment {

    ArrayList<ComicsModel> list = new ArrayList<>();
    ComicsAdapter comicsAdapter = new ComicsAdapter();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comics_market, container, false);
        recyclerView = view.findViewById(R.id.recycler_comics);

        list = ComicsData.getList();
        comicsAdapter.setData(list);

        recyclerView.setAdapter(comicsAdapter);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}