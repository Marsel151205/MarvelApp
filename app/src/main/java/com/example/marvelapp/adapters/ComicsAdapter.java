package com.example.marvelapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelapp.fragments.data.models.ComicsModel;
import com.example.marvelapp.databinding.ItemComicsBinding;

import java.util.ArrayList;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsHolder> {

    ArrayList<ComicsModel> list = new ArrayList<>();

    @NonNull
    @Override
    public ComicsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ComicsHolder(ItemComicsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ComicsHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<ComicsModel> list) {
        this.list = list;
    }

    public class ComicsHolder extends RecyclerView.ViewHolder {

        ItemComicsBinding binding;

        public ComicsHolder(@NonNull  ItemComicsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ComicsModel comicsModel) {
            binding.ivComics.setImageResource(comicsModel.getImageComics());
            binding.tvNameComics.setText(comicsModel.getNameComics());
        }
    }
}
