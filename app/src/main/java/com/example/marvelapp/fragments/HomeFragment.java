package com.example.marvelapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marvelapp.R;
import com.example.marvelapp.adapters.HomeAdapter;
import com.example.marvelapp.fragments.data.HomeData;
import com.example.marvelapp.fragments.data.models.HomeModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<HomeModel> list = new ArrayList<>();
    HomeAdapter homeAdapter = new HomeAdapter();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_home);

        FragmentActivity fragmentActivity = getActivity();
            fragmentActivity.findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);

            list = HomeData.getList();
            homeAdapter.setData(list);
            recyclerView.setAdapter(homeAdapter);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}