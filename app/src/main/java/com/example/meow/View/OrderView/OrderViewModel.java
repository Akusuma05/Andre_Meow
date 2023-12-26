package com.example.meow.View.OrderView;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meow.Model.RecyclerView_Items;
import com.example.meow.R;

import java.util.ArrayList;

public class OrderViewModel {
    public static void RecyclerViewOrder(View view, Context context, ArrayList<RecyclerView_Items> recyclerViewItems){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_order);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5));

        recyclerViewItems = new ArrayList<RecyclerView_Items>();
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(recyclerViewItems, context);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
