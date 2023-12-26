package com.example.meow.View.ProductView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {

    FloatingActionButton floatingActionButton_product;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
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
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TableLayout table = view.findViewById(R.id.table3);
        floatingActionButton_product = view.findViewById(R.id.floatingActionButton_product);

        // Create a new table row for the column titles
        TableRow titleRow = new TableRow(getContext());
        titleRow.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView photo = new TextView(getContext());
        photo.setText("Photo");
        photo.setTypeface(photo.getTypeface(), Typeface.BOLD);
        titleRow.addView(photo);

        TextView name = new TextView(getContext());
        name.setText("Name");
        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        titleRow.addView(name);

        TextView barcode = new TextView(getContext());
        barcode.setText("Barcode");
        barcode.setTypeface(barcode.getTypeface(), Typeface.BOLD);
        titleRow.addView(barcode);

        TextView categories = new TextView(getContext());
        categories.setText("Category");
        categories.setTypeface(categories.getTypeface(), Typeface.BOLD);
        titleRow.addView(categories);

        TextView stock = new TextView(getContext());
        stock.setText("Stock");
        stock.setTypeface(stock.getTypeface(), Typeface.BOLD);
        titleRow.addView(stock);

        TextView price = new TextView(getContext());
        price.setText("Price");
        price.setTypeface(price.getTypeface(), Typeface.BOLD);
        titleRow.addView(price);

        TextView action = new TextView(getContext());
        action.setText("Action");
        action.setTypeface(action.getTypeface(), Typeface.BOLD);
        titleRow.addView(action);

        // Add the title row to the table
        table.addView(titleRow);

        // Add a line after each row
        View line = new View(getContext());
        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line.setBackgroundColor(Color.DKGRAY);
        table.addView(line);

        for (int i = 1; i <= 10; i++) {
            // Create a new table row for the column titles
            TableRow tableRowProduct = new TableRow(getContext());
            tableRowProduct.setPadding(32, 32, 32, 32); // Add padding to the row

            ImageView icon3 = new ImageView(getContext());
            icon3.setImageResource(R.drawable.profilepic);
            icon3.setPadding(16, 16, 16, 16);
            tableRowProduct.addView(icon3);

            // Create the columns
            TextView name1 = new TextView(getContext());
            name1.setText("Name" + i);
            tableRowProduct.addView(name1);

            // Create the columns
            TextView barcode1 = new TextView(getContext());
            barcode1.setText("Barcode" + i);
            tableRowProduct.addView(barcode1);

            // Create the columns
            TextView category1 = new TextView(getContext());
            category1.setText("Category" + i);
            tableRowProduct.addView(category1);

            // Create the columns
            TextView stock1 = new TextView(getContext());
            stock1.setText(String.valueOf(i));
            tableRowProduct.addView(stock1);

            // Create the columns
            TextView price1 = new TextView(getContext());
            price1.setText("Price" + i);
            tableRowProduct.addView(price1);

            LinearLayout iconColumn = new LinearLayout(getContext());
            iconColumn.setOrientation(LinearLayout.HORIZONTAL);

            ImageView icon1 = new ImageView(getContext());
            icon1.setImageResource(R.drawable.edit);
            icon1.setPadding(16, 16, 16, 16);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Icon 1 in " + categories.getText() + " clicked", Toast.LENGTH_SHORT).show();
                    createPopUpEditProduct(getContext(), getView());
                }
            });
            iconColumn.addView(icon1);

            ImageView icon2 = new ImageView(getContext());
            icon2.setImageResource(R.drawable.delete);
            icon2.setPadding(16, 16, 16, 16);
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Icon 2 in " + categories.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon2);

            tableRowProduct.addView(iconColumn);

            // Add the row to the table
            table.addView(tableRowProduct);

            // Add a line after each row
            View line1 = new View(getContext());
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table.addView(line1);

            floatingActionButton_product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createPopUpAddProduct(getContext(), getView());
                }
            });
        }

    }

    private void createPopUpAddProduct(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_add_product, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);
        layout.post(new Runnable(){
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.RIGHT, 0, 0);
            }
        });
        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return false;
            }
        });
    }

    private void createPopUpEditProduct(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_edit_product, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);
        layout.post(new Runnable(){
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.RIGHT, 0, 0);
            }
        });
        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return false;
            }
        });
    }
}