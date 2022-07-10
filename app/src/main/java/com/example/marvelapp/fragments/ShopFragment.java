package com.example.marvelapp.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.marvelapp.R;
import com.example.marvelapp.adapters.MarketAdapter;
import com.example.marvelapp.fragments.data.MarketData;
import com.example.marvelapp.fragments.data.models.MarketModel;
import com.example.marvelapp.inter.OnItemClick;

import java.util.ArrayList;

public class ShopFragment extends Fragment {

    ArrayList<MarketModel> list = new ArrayList<>();
    MarketAdapter marketAdapter = new MarketAdapter();
    RecyclerView recyclerView;
    Button btnBuy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        //initialization
        recyclerView = view.findViewById(R.id.recycler_market);
        btnBuy = view.findViewById(R.id.btn_buy);

        list = MarketData.getList();
        marketAdapter.setData(list);
        recyclerView.setAdapter(marketAdapter);

        marketAdapter.setOnItemClick(new OnItemClick() {
            @Override
            public void OnClick(MarketModel marketModel) {
                Navigation.findNavController(requireView()).navigate(R.id.creditCardFragment);
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}