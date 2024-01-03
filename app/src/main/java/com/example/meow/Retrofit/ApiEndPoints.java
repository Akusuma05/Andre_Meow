package com.example.meow.Retrofit;

import com.example.meow.Model.Categories;
import com.example.meow.Model.Profile;
import com.example.meow.Model.UpdateCategories;

import org.json.JSONObject;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

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

    @PUT("category/{id}")
    Call<JSONObject> putCategories(
            @Path("id") int id,
            @Body UpdateCategories category);

    @DELETE("category/{id}")
    Call<JSONObject> deleteCategories(@Path("id") int id);

}
