package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

public class PagerActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        viewPager = findViewById(R.id.view_pager);

        OnBoardingAdapter onBoardingAdapter = new OnBoardingAdapter(getSupportFragmentManager());
        viewPager.setAdapter(onBoardingAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}