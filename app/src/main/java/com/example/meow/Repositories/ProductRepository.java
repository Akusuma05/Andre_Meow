package com.example.meow.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meow.Model.Categories;
import com.example.meow.Model.Product;
import com.example.meow.Retrofit.RetrofitService;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    public static ProductRepository productRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProductRepository";

    private ProductRepository() {
        Log.d(TAG, "Product Repository Intialized");
        apiService = RetrofitService.getInstance();
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    public LiveData<String> createProduct(String name, String total_product, String type ,String price,String stock) {
        Log.d(TAG, "createCategoriesRepository");
        MutableLiveData<String> message = new MutableLiveData<>();
        apiService.createProduct(name, total_product, type, price, stock).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            String rawJson = new Gson().toJson(response.body());
                            Log.d(TAG, "Raw JSON response: " + rawJson);
                            JSONObject object = new JSONObject(rawJson);
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: "+msg);
                            message.postValue(msg);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }else{
                    Log.d(TAG, "onResponse: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });
        return message;
    }

    public LiveData<List<Product>> getProducts(){
        Log.d(TAG, "getProductsRepository");
        MutableLiveData<List<Product>> listProducts = new MutableLiveData<>();
        apiService.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d(TAG, "Raw JSON response: " + response.body());
                Log.d(TAG, "onResponse: " + response.code());
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Response Not Sucess");
                } else {
                    Log.d(TAG, "size: " + response.body().size());
                    listProducts.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listProducts;
    }

    public LiveData<String> updateProduct(String name, String total_product, String type ,String price,String stock, int id) {
        Log.d(TAG, "updateProductViewModel");
        MutableLiveData<String> message = new MutableLiveData<>();
        apiService.updateProducts(name, total_product, type, price, stock, id).enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            String rawJson = new Gson().toJson(response.body());
                            Log.d(TAG, "Raw JSON response: " + rawJson);
                            JSONObject object = new JSONObject(rawJson);
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: "+msg);
                            message.postValue(msg);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }else{
                        Log.d(TAG, "onResponse: " + response.raw());
                    }
                } else {
                    // Add this line to check for server errors
                    try {
                        Log.d(TAG, "Server returned an error: " + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                // This will print the stack trace for the error
                t.printStackTrace();
            }
        });

        return message;
    }

    public LiveData<String> deleteCategories(int id) {
        MutableLiveData<String> message = new MutableLiveData<>();
        apiService.deleteProducts(id).enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            String rawJson = new Gson().toJson(response.body());
                            Log.d(TAG, "Raw JSON response: " + rawJson);
                            JSONObject object = new JSONObject(rawJson);
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: "+msg);
                            message.postValue(msg);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }else{
                        Log.d(TAG, "onResponse: " + response.raw());
                    }
                } else {
                    // Add this line to check for server errors
                    try {
                        Log.d(TAG, "Server returned an error: " + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                // This will print the stack trace for the error
                t.printStackTrace();
            }
        });
        return message;
    }
}
