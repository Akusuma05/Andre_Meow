package com.example.meow.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meow.Model.Profile;
import com.example.meow.Retrofit.RetrofitService;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    public static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository() {
        Log.d(TAG, "Profile Repository Intialized");
        apiService = RetrofitService.getInstance();
    }

    public static ProfileRepository getInstance() {
        if (profileRepository == null) {
            profileRepository = new ProfileRepository();
        }
        return profileRepository;
    }

    public LiveData<List<Profile>> getUserProfileRepository() {
        Log.d("ProfileRepository", "getUserProfileRepository");
        MutableLiveData<List<Profile>> listProfile = new MutableLiveData<>();
        apiService.getUserRetrofitService().enqueue(new Callback<List<Profile>>() {
            @Override
            public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                Log.d("ProfileRepository", "onResponse: " + response.code());
                if (!response.isSuccessful()) {
                    Log.d("ProfileRepository", "onResponse: Response Not Sucess");
                } else {
                    Log.d("ProfileRepository", "size: " + response.body().size());
                    listProfile.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Profile>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listProfile;
    }

    public LiveData<String> registerUser(String name, String password, String photo_path, String address, String phone, String roles) {
        MutableLiveData<String> message = new MutableLiveData<>();
        apiService.register(name, password, photo_path, address, phone, roles).enqueue(new Callback() {
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
