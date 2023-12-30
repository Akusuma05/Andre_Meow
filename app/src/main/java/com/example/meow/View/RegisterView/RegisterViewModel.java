package com.example.meow.View.RegisterView;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.meow.Repositories.ProfileRepository;

public class RegisterViewModel extends ViewModel {
    private static final String TAG = "RegisterViewModel";
    private ProfileRepository profileRepository;

    public void init(){
        profileRepository = ProfileRepository.getInstance();
    }
    public LiveData<String> register(String name, String password, String photo_path, String address, String phone, String roles){
        Log.d(TAG, "Register");
        return profileRepository.registerUser(name, password, photo_path, address, phone, roles);
    }
}
