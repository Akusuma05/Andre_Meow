package com.example.meow.View.LoginView;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.meow.Model.Profile;
import com.example.meow.Repositories.ProfileRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//public class LoginViewModel extends AndroidViewModel {
//    private ProfileRepository profileRepository;
//    private static final String TAG = "LoginViewModel";
//    public LoginViewModel(@NonNull Application application) {
//        super(application);
////        profileRepository = new ProfileRepository();
////        resultUser = profileRepository.getProfile();
//    }
//
//    public void init(){
//        profileRepository = ProfileRepository.getInstance();
//    }
//
//    private MutableLiveData<Profile> resultUser = new MutableLiveData<>();
//    public void getUsers(){
//        resultUser = profileRepository.getProfile();
//    }
//    public LiveData<Profile> getResultUser(){
//        return resultUser;
//    }
////private ProfileRepository profileRepository;
////    private MutableLiveData<Profile> resultUser;
////
////    public LoginViewModel(@NonNull Application application) {
////        super(application);
////        profileRepository = new ProfileRepository();
////        resultUser = profileRepository.getProfile();
////    }
////
////    public void getUsers(){
////        resultUser = profileRepository.getProfile();
////    }
////
////    public LiveData<Profile> getResultUser(){
////        return resultUser;
////    }
//}
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



