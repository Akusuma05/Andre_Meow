package com.example.meow.View.OrderView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.meow.Model.RecyclerView_Items;
import com.example.meow.R;
import com.example.meow.View.Helper.ShoppingCartHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {

    ArrayList<RecyclerView_Items> recyclerViewItems;
    RecyclerView recyclerView;
    ImageView shopping_cart_order;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
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
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_order);
        shopping_cart_order = view.findViewById(R.id.shopping_cart_order);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));

        recyclerViewItems = new ArrayList<RecyclerView_Items>();
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));
        recyclerViewItems.add(new RecyclerView_Items(R.drawable.profilepic, "Test", "Uhh", "1999", "IDR 1000"));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(recyclerViewItems, getContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        shopping_cart_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingCartHelper.createPopUpShoppingCart(getContext(), getView());
            }
        });
    }


}