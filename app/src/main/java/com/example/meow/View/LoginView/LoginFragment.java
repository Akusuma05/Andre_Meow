package com.example.meow.View.LoginView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meow.Helper.Const;
import com.example.meow.Model.Profile;
import com.example.meow.R;
import com.example.meow.Retrofit.ApiEndPoints;
import com.example.meow.View.ActivityView.View.DashboardActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    //Initialisasi
    TextView btn_reg;
    TextInputLayout username_login, pass_login;
    Button btn_login;

    private LoginViewModel loginViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * Deklarasi Object di dalam fragment Login
         *
         * Object yang di deklarasi
         * @TextInputLayout Username, Password
         * @Button Login
         * @TextView Register
         */
        username_login = view.findViewById(R.id.username_login);
        pass_login = view.findViewById(R.id.password_login);
        btn_login = view.findViewById(R.id.login_button_login);
        btn_reg = view.findViewById(R.id.register_button_login);

        Log.d("LoginFragment", "Login Fragment");
        loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
        loginViewModel.init();
        loginViewModel.getUserViewModel();
        loginViewModel.getResultProfile().observe(getViewLifecycleOwner(), new Observer<List<Profile>>() {
            @Override
            public void onChanged(List<Profile> profiles) {
                // Update your UI here with the profiles
            }
        });

        btn_login.setOnClickListener(view1 -> {
//            if(!username_login.getEditText().getText().toString().trim().isEmpty() &&
//                    !pass_login.getEditText().getText().toString().trim().isEmpty()){
//                String username = username_login.getEditText().getText().toString().trim();
//                String pass = pass_login.getEditText().getText().toString().trim();
//                List<Profile> profiles = loginViewModel.getResultProfile().getValue();
//                for (Profile profile : profiles){
//                    if(profile.getName().equals(username) && profile.getPassword().equals(pass)){
//                        Intent intent = new Intent(getActivity(), DashboardActivity.class);
//                        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        startActivity(intent);
//                        return;
//                    }
//                }
//                Toast.makeText(getActivity(), "Wrong Username or Password",
//                        Toast.LENGTH_LONG).show();
//            }
            Intent intent = new Intent(getActivity(), DashboardActivity.class);
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        });


        /**
         * Tombol Register Here samping tulisan don't have account
         *
         * Di click buat pindah kehalaman register
         */
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        /**
         * Tombol Login
         *
         * @Input username_login, pass_login
         * @Output kalau sesuai pindah ke activity_dashboard
         */

    }

    List<Profile> results = new ArrayList<>();

    private Observer<Profile> showUser = new Observer<Profile>() {
        @Override
        public void onChanged(Profile profile) {
//            results = profile.getCourses();
//            linearLayoutManager = new LinearLayoutManager(getActivity());
//            recyclerView.setLayoutManager(linearLayoutManager);
//            courseAdapter = new CourseAdapter(getActivity());
//            courseAdapter.setCoursesList(results);
//            recyclerView.setAdapter(courseAdapter);
//            for(int x = 0; x <= 2; x++){
//                Log.wtf("Andre manuk: ", profile.getName());
//            }
            btn_reg.setText(profile.getName());
            btn_login.setText(profile.getName());
        }
    };

}