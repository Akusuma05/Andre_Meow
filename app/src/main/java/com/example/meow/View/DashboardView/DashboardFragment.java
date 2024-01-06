package com.example.meow.View.DashboardView;

import android.graphics.Typeface;
import android.os.Bundle;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.meow.Model.Order;
import com.example.meow.Model.OrderItem;
import com.example.meow.Model.Product;
import com.example.meow.Model.RecyclerView_Items;
import com.example.meow.R;
import com.example.meow.View.Helper.ShoppingCartHelper;
import com.example.meow.View.OrderView.OrderViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Tombol Shopping Cart Dashboard
        ImageView shopping_cart_dashboard = view.findViewById(R.id.shopping_cart_dashboard);
        shopping_cart_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingCartHelper.createPopUpShoppingCart(getContext(), getView());
            }
        });

        DashboardViewModel.createLineGraphDashboard(getView());
        DashboardViewModel.createPieChartDashboard(getView());

        dashboardViewModel = new ViewModelProvider(getActivity()).get(DashboardViewModel.class);
        dashboardViewModel.init();
        dashboardViewModel.getOrderViewModel();
        dashboardViewModel.getOrderItemViewModel();
        dashboardViewModel.getProductOrderViewModel();
        dashboardViewModel.getResultOrderDashboard().observe(getViewLifecycleOwner(), new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> listOrder) {
                dashboardViewModel.getResultOrderItemDashboard().observe(getViewLifecycleOwner(), new Observer<List<OrderItem>>() {
                    @Override
                    public void onChanged(List<OrderItem> listOrderItem) {
                        dashboardViewModel.getResultProductOrderDashboard().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
                            @Override
                            public void onChanged(List<Product> listProduct) {
                                DashboardViewModel.createTableDashboard(getView(), getContext(), listOrder, listOrderItem, listProduct);
                            }
                        });
                    }
                });
            }
        });


    }
}