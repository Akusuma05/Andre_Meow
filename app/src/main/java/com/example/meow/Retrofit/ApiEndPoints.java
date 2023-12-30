package com.example.meow.Retrofit;

import com.example.meow.Model.Profile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoints {
    @POST("user")
    @FormUrlEncoded
    Call<Profile> register(@Field("name") String name, @Field("email") String email,
                           @Field("password") String password);
    @GET("user")
    Call<List<Profile>>getUser();

}
