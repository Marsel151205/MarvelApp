package com.example.marvelapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.marvelapp.fragments.OnBoardingFragment1;
import com.example.marvelapp.fragments.OnBoardingFragment2;
import com.example.marvelapp.fragments.OnBoardingFragment3;

public class OnBoardingAdapter extends FragmentPagerAdapter {


    public OnBoardingAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OnBoardingFragment2();
            case 1:
                return new OnBoardingFragment1();
            case 2:
                return new OnBoardingFragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
