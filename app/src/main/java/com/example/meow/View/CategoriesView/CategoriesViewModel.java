package com.example.meow.View.CategoriesView;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
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

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.meow.Model.Categories;
import com.example.meow.Model.Profile;
import com.example.meow.R;
import com.example.meow.Repositories.CategoriesRepository;
import com.example.meow.Repositories.ProfileRepository;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class CategoriesViewModel extends ViewModel {

    private static final String TAG = "CategoriesViewModel";
    private CategoriesRepository categoriesRepository;
    private LiveData<List<Categories>> resultCategories;

    public void init(){
        categoriesRepository = CategoriesRepository.getInstance();
        resultCategories = new MutableLiveData<>();
    }

    public void getCategoriesViewModel() {
        Log.d(TAG, "GetCategoriesViewModel");
        resultCategories = categoriesRepository.getCategories();
    }

    public LiveData<List<Categories>> getResultCategories() {
        return resultCategories;
    }

    public LiveData<String> createCategoriesViewModel(String name, String total_product){
        Log.d(TAG, "Register");
        return categoriesRepository.createCategories(name, total_product);
    }

    /**
     * Function Buat Keluarin Pop Up Add Category
     *
     * Input: getContext(), getView()
     * Elements: popupView
     * Output: popup_add_categories
     *
     * Usage: Fragment Categories
     * */
    public static void createPopUpAddCategory(Context context, View layout, Activity activity) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_add_categories, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

        TextInputLayout category_add_category = popUpView.findViewById(R.id.category_add_category);
        Button done_add_category = popUpView.findViewById(R.id.done_add_category);

        CategoriesViewModel categoriesViewModel = new ViewModelProvider((ViewModelStoreOwner) activity).get(CategoriesViewModel.class);
        categoriesViewModel.init();

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
        done_add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!category_add_category.getEditText().getText().toString().trim().isEmpty()){
                    String name = category_add_category.getEditText().getText().toString().trim();
                    categoriesViewModel.createCategoriesViewModel(name, "0");
                    popupWindow.dismiss();
                }
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
    public static void createTableCategories(Context context, View view, Activity activity, List<Categories> listCategories){
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

        for (int i = 0; i < listCategories.size(); i++) {
            // Create a new table row for the column titles
            TableRow tableRowCategories = new TableRow(context);
            tableRowCategories.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView categories1 = new TextView(context);
            categories1.setText(listCategories.get(i).getName());
            tableRowCategories.addView(categories1);

            // Create the columns
            TextView stock = new TextView(context);
            stock.setText(String.valueOf(listCategories.get(i).getTotal_product()));
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
                    createPopUpAddCategory(context, view, activity);
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
