package com.example.meow.Retrofit;

import com.example.meow.Model.Categories;
import com.example.meow.Model.Order;
import com.example.meow.Model.OrderItem;
import com.example.meow.Model.Product;
import com.example.meow.Model.Profile;
import com.example.meow.Model.UpdateCategories;
import com.example.meow.Model.UpdateProduct;

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
    /**
     * User
     * */
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

    /**
     * Category
     * */
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

    /**
     * Product
     * */
    @GET("product")
    Call<List<Product>> getProducts();

    @Multipart
    @POST("product")
    Call<JSONObject> createProducts(@Part("name") RequestBody name,
                              @Part("image_path") RequestBody image_path,
                              @Part("price") RequestBody price,
                              @Part("stock") RequestBody stock,
                              @Part("type") RequestBody type);

    @PUT("product/{id}")
    Call<JSONObject> putProducts(
            @Path("id") int id,
            @Body UpdateProduct product);

    @DELETE("product/{id}")
    Call<JSONObject> deleteProducts(@Path("id") int id);

    /**
     * Order
     * */
    @GET("order")
    Call<List<Order>> getOrder();


    /**
     * Order Item
     * */
    @GET("order_item")
    Call<List<OrderItem>> getOrderItem();
}
