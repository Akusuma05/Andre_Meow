package com.example.meow.View.LoginView;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.meow.Model.Profile;
import com.example.meow.Repositories.ProfileRepository;

import java.util.List;

public class LoginViewModel extends ViewModel {
    private static final String TAG = "LoginViewModel";
    private ProfileRepository profileRepository;
    private LiveData<List<Profile>> resultProfile;

    public void init(){
        profileRepository = ProfileRepository.getInstance();
        resultProfile = new MutableLiveData<>();
    }

    public void getUserViewModel() {
        Log.d(TAG, "GetUserViewModel");
        resultProfile = profileRepository.getUserProfileRepository();
    }

    public LiveData<List<Profile>> getResultProfile() {
        return resultProfile;
    }


}



