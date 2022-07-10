package com.example.marvelapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelapp.databinding.ItemMarketBinding;
import com.example.marvelapp.fragments.data.models.MarketModel;
import com.example.marvelapp.inter.OnItemClick;

import java.util.ArrayList;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketHolder> {

    ArrayList<MarketModel> list = new ArrayList<>();

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MarketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MarketHolder(ItemMarketBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MarketHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<MarketModel> list) {
        this.list = list;
    }

    public class MarketHolder extends RecyclerView.ViewHolder {

        ItemMarketBinding binding;

        public MarketHolder(@NonNull ItemMarketBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(MarketModel marketModel) {
            binding.ivImageMarket.setImageResource(marketModel.getImageMarket());
            binding.tvNameComicsMarket.setText(marketModel.getNameComicsMarket());
            binding.tvPriceComics.setText(marketModel.getPriceMarket());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick.OnClick(marketModel);
                }
            });
        }
    }
}
