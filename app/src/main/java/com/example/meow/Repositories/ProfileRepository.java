package com.example.meow.Repositories;

import static java.sql.DriverManager.println;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meow.Helper.Const;
import com.example.meow.Model.Profile;
import com.example.meow.Retrofit.ApiEndPoints;
import com.example.meow.Retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileRepository {
    public static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository(){
        Log.d(TAG, "Profile Repository Intialized");
        apiService = RetrofitService.getInstance();
    }

    public static ProfileRepository getInstance(){
        if (profileRepository== null){
            profileRepository = new ProfileRepository();
        }
        return profileRepository;
    }

    public LiveData<List<Profile>> getUserProfileRepository(){
        Log.d("ProfileRepository", "getUserProfileRepository");
        MutableLiveData<List<Profile>> listProfile = new MutableLiveData<>();
        apiService.getUserRetrofitService().enqueue(new Callback<List<Profile>>() {
            @Override
            public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                Log.d("ProfileRepository", "APITest");
                Log.d("ProfileRepository", "onResponse: "+response.code());
                if(!response.isSuccessful()){
                    Log.d("ProfileRepository", "onResponse: Response Not Sucess");
                }else{
                    Log.d("ProfileRepository", "size: "+response.body().size());
                    listProfile.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Profile>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
        return listProfile;
    }
}
