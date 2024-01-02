package com.example.meow.Retrofit;

import com.example.meow.Model.Categories;
import com.example.meow.Model.Profile;

import org.json.JSONObject;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiEndPoints {
    @Multipart
    @POST("user")
    Call<JSONObject> register(@Part("name") RequestBody name,
                              @Part("password") RequestBody password,
                              @Part("photo_path") RequestBody photo_path,
                              @Part("address") RequestBody address,
                              @Part("phone") RequestBody phone,
                              @Part("roles") RequestBody roles);

    @GET("user")
    Call<List<Profile>>getUser();

    @GET("category")
    Call<List<Categories>>getCategories();

    @Multipart
    @POST("category")
    Call<JSONObject> postCategories(@Part("name") RequestBody name,
                              @Part("total_product") RequestBody total_product);

}
