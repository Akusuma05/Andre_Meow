package com.example.meow.View.CategoriesView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meow.Model.Categories;
import com.example.meow.Model.Profile;
import com.example.meow.R;
import com.example.meow.Repositories.CategoriesRepository;
import com.example.meow.View.Helper.ShoppingCartHelper;
import com.example.meow.View.LoginView.LoginViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment {

    private CategoriesViewModel categoriesViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
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
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Tombol Shopping Cart
        ImageView shopping_cart_categories = view.findViewById(R.id.shopping_cart_categories);
        shopping_cart_categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingCartHelper.createPopUpShoppingCart(getContext(), getView());
            }
        });

        //Tombol Categories
        FloatingActionButton floatingActionButton_categories = view.findViewById(R.id.floatingActionButton_categories);
        floatingActionButton_categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriesViewModel.createPopUpAddCategory(getContext(), getView(), getActivity(), "add", 0);
            }
        });

        Log.d("CategoryFragment", "Category Fragment");
        categoriesViewModel = new ViewModelProvider(getActivity()).get(CategoriesViewModel.class);
        categoriesViewModel.init();
        categoriesViewModel.getCategoriesViewModel();
        categoriesViewModel.getResultCategories().observe(getViewLifecycleOwner(), new Observer<List<Categories>>() {
            @Override
            public void onChanged(List<Categories> listCategories) {
                //Function Membuat Table
                CategoriesViewModel.createTableCategories(getContext(), getView(), getActivity(), listCategories);
            }
        });
//        List<Categories> listCategories = categoriesViewModel.getResultCategories().getValue();


    }
}