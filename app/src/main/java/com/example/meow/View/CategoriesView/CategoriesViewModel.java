package com.example.meow.View.CategoriesView;

import static java.security.AccessController.getContext;

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

public class CategoriesViewModel {

    /**
     * Function Buat Keluarin Pop Up Add Category
     *
     * Input: getContext(), getView()
     * Elements: popupView
     * Output: popup_add_categories
     *
     * Usage: Fragment Categories
     * */
    public static void createPopUpAddCategory(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_add_categories, null);

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

    /**
     * Function Buat Keluarin Table di Categories
     *
     * Input: getContext(), getView()
     * Elements: table2
     * Output: content dari table2
     *
     * Usage: Fragment Categories
     * */
    public static void createTableCategories(Context context, View view){
        TableLayout table = view.findViewById(R.id.table2);
        // Create a new table row for the column titles
        TableRow titleRow = new TableRow(context);
        titleRow.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView categories = new TextView(context);
        categories.setText("Categories");
        categories.setTypeface(categories.getTypeface(), Typeface.BOLD);
        titleRow.addView(categories);

        TextView date = new TextView(context);
        date.setText("Stock");
        date.setTypeface(date.getTypeface(), Typeface.BOLD);
        titleRow.addView(date);

        TextView time = new TextView(context);
        time.setText("Action");
        time.setTypeface(time.getTypeface(), Typeface.BOLD);
        titleRow.addView(time);

        // Add the title row to the table
        table.addView(titleRow);

        // Add a line after each row
        View line = new View(context);
        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line.setBackgroundColor(Color.DKGRAY);
        table.addView(line);

        for (int i = 1; i <= 10; i++) {
            // Create a new table row for the column titles
            TableRow tableRowCategories = new TableRow(context);
            tableRowCategories.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView categories1 = new TextView(context);
            categories1.setText("Categories" + i);
            tableRowCategories.addView(categories1);

            // Create the columns
            TextView stock = new TextView(context);
            stock.setText(String.valueOf(i));
            tableRowCategories.addView(stock);

            LinearLayout iconColumn = new LinearLayout(context);
            iconColumn.setOrientation(LinearLayout.HORIZONTAL);

            ImageView icon1 = new ImageView(context);
            icon1.setImageResource(R.drawable.edit);
            icon1.setPadding(16, 16, 16, 16);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Icon 1 in " + categories.getText() + " clicked", Toast.LENGTH_SHORT).show();
                    createPopUpAddCategory(context, view);
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

            tableRowCategories.addView(iconColumn);

            // Add the row to the table
            table.addView(tableRowCategories);

            // Add a line after each row
            View line1 = new View(context);
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table.addView(line1);
        }
    }
}
