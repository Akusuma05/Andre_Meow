package com.example.meow.View.RegisterView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.meow.R;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    //Deklarasi

    TextView btn_login;
    TextInputLayout username_regis, pass_regis, address_regis, phone_regis;
    Button btn_regis;
    Spinner role_regis;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * Deklarasi Object di dalam fragment Login
         *
         * Object yang di deklarasi
         * @TextInputLayout Username, Password, Alamat, Nomer Telepon
         * @Spinner Role
         * @Button Register
         * @TextView Login
         */
        username_regis = view.findViewById(R.id.username_register);
        pass_regis = view.findViewById(R.id.password_register);
        address_regis = view.findViewById(R.id.address_register);
        phone_regis = view.findViewById(R.id.phonenumber_register);
        role_regis = view.findViewById(R.id.role_register);
        btn_login = view.findViewById(R.id.login_button_register);
        btn_regis = view.findViewById(R.id.register_button_register);

        /**
         * Tombol Login Here samping tulisan have an account
         *
         * Di click buat pindah kehalaman Login
         */
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment2();
                Navigation.findNavController(view).navigate(action);
            }
        });

        /**
         * Tombol Register
         *
         * @Input username_login, pass_login, role_regis, phone_regis, address_regis
         * @Output kalau sesuai pindah ke activity_dashboard
         */
        btn_regis.setOnClickListener(view1 -> {

        });
    }
}