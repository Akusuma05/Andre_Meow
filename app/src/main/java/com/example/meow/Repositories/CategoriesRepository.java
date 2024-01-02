package com.example.meow.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meow.Model.Categories;
import com.example.meow.Model.Profile;
import com.example.meow.Retrofit.RetrofitService;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRepository {
    public static CategoriesRepository categoriesRepository;
    private RetrofitService apiService;
    private static final String TAG = "CategoriesRepository";

    private CategoriesRepository() {
        Log.d(TAG, "Categories Repository Intialized");
        apiService = RetrofitService.getInstance();
    }

    public static CategoriesRepository getInstance() {
        if (categoriesRepository == null) {
            categoriesRepository = new CategoriesRepository();
        }
        return categoriesRepository;
    }

    public LiveData<List<Categories>> getCategories(){
        Log.d(TAG, "getCategoriesRepository");
        MutableLiveData<List<Categories>> listCategories = new MutableLiveData<>();
        apiService.getCategoriesRetrofitService().enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                Log.d(TAG, "Raw JSON response: " + response.body());
                Log.d(TAG, "onResponse: " + response.code());
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Response Not Sucess");
                } else {
                    Log.d(TAG, "size: " + response.body().size());
                    listCategories.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listCategories;
    }

    public LiveData<String> createCategories(String name, String total_product) {
        MutableLiveData<String> message = new MutableLiveData<>();
        apiService.createCategories(name, total_product).enqueue(new Callback() {
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
}
