package com.example.meow.View.ProductView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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

import com.example.meow.R;

public class ProductViewModel {
    /**
     * Function Buat Keluarin Table Product di Product
     *
     * Input: getContext(), getView()
     * Elements: table3
     * Output: content dari table3
     *
     * Usage: Fragment Product
     * */
    public static void createTableProduct(View view, Context context) {
        TableLayout table = view.findViewById(R.id.table3);
        // Create a new table row for the column titles
        TableRow titleRow = new TableRow(context);
        titleRow.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView photo = new TextView(context);
        photo.setText("Photo");
        photo.setTypeface(photo.getTypeface(), Typeface.BOLD);
        titleRow.addView(photo);

        TextView name = new TextView(context);
        name.setText("Name");
        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        titleRow.addView(name);

        TextView barcode = new TextView(context);
        barcode.setText("Barcode");
        barcode.setTypeface(barcode.getTypeface(), Typeface.BOLD);
        titleRow.addView(barcode);

        TextView categories = new TextView(context);
        categories.setText("Category");
        categories.setTypeface(categories.getTypeface(), Typeface.BOLD);
        titleRow.addView(categories);

        TextView stock = new TextView(context);
        stock.setText("Stock");
        stock.setTypeface(stock.getTypeface(), Typeface.BOLD);
        titleRow.addView(stock);

        TextView price = new TextView(context);
        price.setText("Price");
        price.setTypeface(price.getTypeface(), Typeface.BOLD);
        titleRow.addView(price);

        TextView action = new TextView(context);
        action.setText("Action");
        action.setTypeface(action.getTypeface(), Typeface.BOLD);
        titleRow.addView(action);

        // Add the title row to the table
        table.addView(titleRow);

        // Add a line after each row
        View line = new View(context);
        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line.setBackgroundColor(Color.DKGRAY);
        table.addView(line);

        for (int i = 1; i <= 10; i++) {
            // Create a new table row for the column titles
            TableRow tableRowProduct = new TableRow(context);
            tableRowProduct.setPadding(32, 32, 32, 32); // Add padding to the row

            ImageView icon3 = new ImageView(context);
            icon3.setImageResource(R.drawable.profilepic);
            icon3.setPadding(16, 16, 16, 16);
            tableRowProduct.addView(icon3);

            // Create the columns
            TextView name1 = new TextView(context);
            name1.setText("Name" + i);
            tableRowProduct.addView(name1);

            // Create the columns
            TextView barcode1 = new TextView(context);
            barcode1.setText("Barcode" + i);
            tableRowProduct.addView(barcode1);

            // Create the columns
            TextView category1 = new TextView(context);
            category1.setText("Category" + i);
            tableRowProduct.addView(category1);

            // Create the columns
            TextView stock1 = new TextView(context);
            stock1.setText(String.valueOf(i));
            tableRowProduct.addView(stock1);

            // Create the columns
            TextView price1 = new TextView(context);
            price1.setText("Price" + i);
            tableRowProduct.addView(price1);

            LinearLayout iconColumn = new LinearLayout(context);
            iconColumn.setOrientation(LinearLayout.HORIZONTAL);

            ImageView icon1 = new ImageView(context);
            icon1.setImageResource(R.drawable.edit);
            icon1.setPadding(16, 16, 16, 16);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Icon 1 in " + categories.getText() + " clicked", Toast.LENGTH_SHORT).show();
                    createPopUpEditProduct(context, view);
                }
            });
            iconColumn.addView(icon1);

            ImageView icon2 = new ImageView(context);
            icon2.setImageResource(R.drawable.delete);
            icon2.setPadding(16, 16, 16, 16);
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Icon 2 in " + categories.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon2);

            tableRowProduct.addView(iconColumn);

            // Add the row to the table
            table.addView(tableRowProduct);

            // Add a line after each row
            View line1 = new View(context);
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table.addView(line1);
        }
    }

    /**
     * Function Buat Keluarin Pop Up Add Product
     *
     * Input: getContext(), getView()
     * Elements: popupView
     * Output: popup_add_product
     *
     * Usage: floatingActionButton_product (Fragment Product)
     * */
    public static void createPopUpAddProduct(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_add_product, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        layout.post(new Runnable() {
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

    /**
     * Function Buat Keluarin Pop Up Edit Product
     *
     * Input: getContext(), getView()
     * Elements: icon1
     * Output: popup_add_product
     *
     * Usage: icon1 (ProductViewModel)
     * */
    private static void createPopUpEditProduct(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_edit_product, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        layout.post(new Runnable() {
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
