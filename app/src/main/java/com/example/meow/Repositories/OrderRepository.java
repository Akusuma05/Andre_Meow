package com.example.meow.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meow.Model.Order;
import com.example.meow.Model.Product;
import com.example.meow.Retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {
    public static OrderRepository orderRepository;
    private RetrofitService apiService;
    private static final String TAG = "OrderRepository";

    private OrderRepository() {
        Log.d(TAG, "Order Repository Intialized");
        apiService = RetrofitService.getInstance();
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepository();
        }
        return orderRepository;
    }

    public LiveData<List<Order>> getOrder(){
        Log.d(TAG, "getOrderRepository");
        MutableLiveData<List<Order>> listOrder = new MutableLiveData<>();
        apiService.getOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                Log.d(TAG, "Raw JSON response: " + response.body());
                Log.d(TAG, "onResponse: " + response.code());
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Response Not Sucess");
                } else {
                    Log.d(TAG, "size: " + response.body().size());
                    listOrder.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listOrder;
    }
}
