package com.example.marvelapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelapp.databinding.ItemHomeBinding;
import com.example.marvelapp.fragments.data.models.HomeModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {

    ArrayList<HomeModel> list = new ArrayList<>();

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    public void setData(ArrayList<HomeModel> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeHolder extends RecyclerView.ViewHolder {

        ItemHomeBinding binding;

        public HomeHolder(@NonNull ItemHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(HomeModel homeModel) {
            binding.ivAvengers.setImageResource(homeModel.getImageHome());
            binding.tvNameComics.setText(homeModel.getNameHome());
        }
    }
}
