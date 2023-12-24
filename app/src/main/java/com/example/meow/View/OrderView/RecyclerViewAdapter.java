package com.example.meow.View.OrderView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meow.Model.RecyclerView_Items;
import com.example.meow.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<RecyclerView_Items> recyclerViewItems;
    private Context context;

    public RecyclerViewAdapter(ArrayList<RecyclerView_Items> recyclerViewItems, Context context) {
        this.recyclerViewItems = recyclerViewItems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.image_card_product.setImageResource(recyclerViewItems.get(position).getImage());
        holder.name_card_product.setText(recyclerViewItems.get(position).getName());
        holder.categories_card_product.setText(recyclerViewItems.get(position).getCategories());
        holder.amount_card_product.setText(recyclerViewItems.get(position).getAmount());
        holder.price_card_product.setText(recyclerViewItems.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_card_product;
        TextView name_card_product, categories_card_product, amount_card_product, price_card_product;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_card_product = itemView.findViewById(R.id.image_card_product);
            name_card_product = itemView.findViewById(R.id.name_card_product);
            categories_card_product = itemView.findViewById(R.id.categories_card_product);
            amount_card_product = itemView.findViewById(R.id.amount_card_product);
            price_card_product = itemView.findViewById(R.id.price_card_product);


        }
    }
}
