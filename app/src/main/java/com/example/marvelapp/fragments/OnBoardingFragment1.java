package com.example.marvelapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marvelapp.MainActivity;
import com.example.marvelapp.R;
import com.example.marvelapp.databinding.FragmentOnBoarding1Binding;

public class OnBoardingFragment1 extends Fragment {

    ViewPager viewPager;
    Button btnSkip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_boarding1, container, false);

        viewPager = getActivity().findViewById(R.id.view_pager);
        btnSkip = getActivity().findViewById(R.id.btn_next2);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}