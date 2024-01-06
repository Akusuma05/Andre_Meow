package com.example.meow.View.OrderView;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meow.Model.Product;
import com.example.meow.Model.RecyclerView_Items;
import com.example.meow.R;
import com.example.meow.Repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderViewModel extends ViewModel {
    private static final String TAG = "OrderViewModel";
    private ProductRepository productRepository;
    private LiveData<List<Product>> resultProduct;

    public void init(){
        productRepository = ProductRepository.getInstance();
        resultProduct = new MutableLiveData<>();
    }

    public void getOrderViewModel() {
        Log.d(TAG, "GetProductsViewModel");
        resultProduct = productRepository.getProducts();
    }

    public LiveData<List<Product>> getResultProductOrder() {
        return resultProduct;
    }

    public static void RecyclerViewOrder(View view, Context context, ArrayList<RecyclerView_Items> recyclerViewItems, List<Product> listProduct){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_order);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5));

        recyclerViewItems = new ArrayList<RecyclerView_Items>();
        for (int i = 0; i < listProduct.size(); i++){
            recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic,
                    listProduct.get(i).getName(),
                    String.valueOf(listProduct.get(i).getType()),
                    String.valueOf(listProduct.get(i).getStock()),
                    String.valueOf(listProduct.get(i).getPrice())));
        }
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
//        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(recyclerViewItems, context);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
