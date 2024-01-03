package com.example.meow.Retrofit;

import android.util.Log;

import com.example.meow.Helper.Const;
import com.example.meow.Model.Categories;
import com.example.meow.Model.Profile;
import com.example.meow.Model.UpdateCategories;

import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static RetrofitService service;
    private final ApiEndPoints apiEndPoints;
    private static final String TAG = "RetrofitService";

    public RetrofitService(){
        Log.d(TAG, "Make New Retrofit Service");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL) // replace with your base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiEndPoints = retrofit.create(ApiEndPoints.class);
    }

    public static RetrofitService getInstance(){
        if (service == null){
            Log.d(TAG, "GetInstance");
            service = new RetrofitService();
        }else{
            Log.d(TAG, "Failed GetInstance");
        }
        return service;
    }

    /**
     * User
     * */
    public Call<List<Profile>> getUserRetrofitService(){ return apiEndPoints.getUser();}

    public Call<JSONObject> register(String name, String password, String photo_path, String address, String phone, String roles){
        RequestBody namePart = RequestBody.create(MediaType.parse("text/plain"), name);
        RequestBody passwordPart = RequestBody.create(MediaType.parse("text/plain"), password);
        RequestBody photoPathPart = RequestBody.create(MediaType.parse("text/plain"), photo_path);
        RequestBody addressPart = RequestBody.create(MediaType.parse("text/plain"), address);
        RequestBody phonePart = RequestBody.create(MediaType.parse("text/plain"), phone);
        RequestBody rolesPart = RequestBody.create(MediaType.parse("text/plain"), roles);

        return apiEndPoints.register(namePart, passwordPart, photoPathPart, addressPart, phonePart, rolesPart);
    }

    /**
     * Categories
     * */
    public Call<List<Categories>> getCategoriesRetrofitService(){return apiEndPoints.getCategories();}

    public Call<JSONObject> createCategories(String name, String total_product){
        RequestBody namePart = RequestBody.create(MediaType.parse("text/plain"), name);
        RequestBody total_product_part = RequestBody.create(MediaType.parse("text/plain"), total_product);

        return apiEndPoints.postCategories(namePart, total_product_part);
    }

    public Call<JSONObject> updateCategories(String name, String total_product, int id){
        Log.d(TAG, "updateCategories View Model");
        UpdateCategories categories = new UpdateCategories();
        categories.setName(name);
        categories.setTotal_product(total_product);
        Log.d(TAG, categories.getName());
        Log.d(TAG, categories.getTotal_product());
        return apiEndPoints.putCategories(id, categories);
    }

    public Call<JSONObject> deleteCategories(){
        return apiEndPoints.deleteCategories();
    }
}
