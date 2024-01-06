package com.example.meow.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meow.Model.Order;
import com.example.meow.Model.OrderItem;
import com.example.meow.Retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderItemRepository {
    public static OrderItemRepository orderItemRepository;
    private RetrofitService apiService;
    private static final String TAG = "OrderItemRepository";

    private OrderItemRepository() {
        Log.d(TAG, "Order Repository Intialized");
        apiService = RetrofitService.getInstance();
    }

    public static OrderItemRepository getInstance() {
        if (orderItemRepository == null) {
            orderItemRepository = new OrderItemRepository();
        }
        return orderItemRepository;
    }

    public LiveData<List<OrderItem>> getOrderItem(){
        Log.d(TAG, "getOrderRepository");
        MutableLiveData<List<OrderItem>> listOrderItem = new MutableLiveData<>();
        apiService.getOrderItems().enqueue(new Callback<List<OrderItem>>() {
            @Override
            public void onResponse(Call<List<OrderItem>> call, Response<List<OrderItem>> response) {
                Log.d(TAG, "Raw JSON response: " + response.body());
                Log.d(TAG, "onResponse: " + response.code());
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Response Not Sucess");
                } else {
                    Log.d(TAG, "size: " + response.body().size());
                    listOrderItem.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<OrderItem>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listOrderItem;
    }
}
