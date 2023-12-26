package com.example.meow.View.EmployeeView;

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

public class EmployeeViewModel {
    /**
     * Function Buat Keluarin Table Active Employee di Employee
     *
     * Input: getContext(), getView()
     * Elements: table_active_employee
     * Output: content dari table_active_employee
     *
     * Usage: Fragment Employee
     * */
    public static void createActiveEmployeeTable(View view, Context context) {
        TableLayout table_active_employee = view.findViewById(R.id.table_active_employee);

        // Create a new table row for the column titles
        TableRow tableActiveEmployee = new TableRow(context);
        tableActiveEmployee.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView name = new TextView(context);
        name.setText("Name");
        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        tableActiveEmployee.addView(name);

        TextView phone = new TextView(context);
        phone.setText("Phone Number");
        phone.setTypeface(phone.getTypeface(), Typeface.BOLD);
        tableActiveEmployee.addView(phone);

        TextView action = new TextView(context);
        action.setText("Action");
        action.setTypeface(action.getTypeface(), Typeface.BOLD);
        tableActiveEmployee.addView(action);

        // Add the title row to the table
        table_active_employee.addView(tableActiveEmployee);

        // Add a line after each row
        View line = new View(context);
        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line.setBackgroundColor(Color.DKGRAY);
        table_active_employee.addView(line);

        for (int i = 1; i <= 10; i++) {
            // Create a new table row for the column titles
            TableRow tableActiveEmployeeContent = new TableRow(context);
            tableActiveEmployeeContent.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView name1 = new TextView(context);
            name1.setText("Name" + i);
            tableActiveEmployeeContent.addView(name1);

            // Create the columns
            TextView phone1 = new TextView(context);
            phone1.setText(String.valueOf(i));
            tableActiveEmployeeContent.addView(phone1);

            LinearLayout iconColumn = new LinearLayout(context);
            iconColumn.setOrientation(LinearLayout.HORIZONTAL);

            ImageView icon1 = new ImageView(context);
            icon1.setImageResource(R.drawable.edit);
            icon1.setPadding(16, 16, 16, 16);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Icon 1 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                    createPopUpEditEmployee(context, view);
                }
            });
            iconColumn.addView(icon1);

            ImageView icon2 = new ImageView(context);
            icon2.setImageResource(R.drawable.delete);
            icon2.setPadding(16, 16, 16, 16);
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Icon 2 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon2);

            tableActiveEmployeeContent.addView(iconColumn);

            // Add the row to the table
            table_active_employee.addView(tableActiveEmployeeContent);

            // Add a line after each row
            View line1 = new View(context);
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table_active_employee.addView(line1);
        }
    }

    /**
     * Function Buat Keluarin Table Pending Employee di Employee
     *
     * Input: getContext(), getView()
     * Elements: table_pending_employee
     * Output: content dari table_pending_employee
     *
     * Usage: Fragment Employee
     * */
    public static void createPendingEmployeeTable(View view, Context context) {
        TableLayout table_pending_employee = view.findViewById(R.id.table_pending_employee);

        // Create a new table row for the column titles
        TableRow tablePendingEmployee = new TableRow(context);
        tablePendingEmployee.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView name3 = new TextView(context);
        name3.setText("Name");
        name3.setTypeface(name3.getTypeface(), Typeface.BOLD);
        tablePendingEmployee.addView(name3);

        TextView phone3 = new TextView(context);
        phone3.setText("Phone Number");
        phone3.setTypeface(phone3.getTypeface(), Typeface.BOLD);
        tablePendingEmployee.addView(phone3);

        TextView action3 = new TextView(context);
        action3.setText("Action");
        action3.setTypeface(action3.getTypeface(), Typeface.BOLD);
        tablePendingEmployee.addView(action3);

        // Add the title row to the table
        table_pending_employee.addView(tablePendingEmployee);

        // Add a line after each row
        View line2 = new View(context);
        line2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line2.setBackgroundColor(Color.DKGRAY);
        table_pending_employee.addView(line2);

        for (int i = 1; i <= 10; i++) {
            // Create a new table row for the column titles
            TableRow tablePendingEmployeeContent = new TableRow(context);
            tablePendingEmployeeContent.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView name1 = new TextView(context);
            name1.setText("Name" + i);
            tablePendingEmployeeContent.addView(name1);

            // Create the columns
            TextView phone1 = new TextView(context);
            phone1.setText(String.valueOf(i));
            tablePendingEmployeeContent.addView(phone1);

            LinearLayout iconColumn = new LinearLayout(context);
            iconColumn.setOrientation(LinearLayout.HORIZONTAL);

            ImageView icon1 = new ImageView(context);
            icon1.setImageResource(R.drawable.check_box);
            icon1.setPadding(16, 16, 16, 16);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Icon 1 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon1);

            ImageView icon2 = new ImageView(context);
            icon2.setImageResource(R.drawable.cross_box);
            icon2.setPadding(16, 16, 16, 16);
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Icon 2 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon2);

            tablePendingEmployeeContent.addView(iconColumn);

            // Add the row to the table
            table_pending_employee.addView(tablePendingEmployeeContent);

            // Add a line after each row
            View line1 = new View(context);
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table_pending_employee.addView(line1);
        }
    }

    /**
     * Function Buat Keluarin Pop Up Add Employee
     *
     * Input: getContext(), getView()
     * Elements: popupView
     * Output: popup_add_employee
     *
     * Usage: floatingActionButton_employee (Fragment Employee)
     * */
    public static void createPopUpAddEmployee(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_add_employee, null);

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
     * Function Buat Keluarin Pop Up Edit Employee
     *
     * Input: getContext(), getView()
     * Elements: popupView
     * Output: popup_edit_employee
     *
     * Usage: icon1 (EmployeeViewModel)
     * */
    private static void createPopUpEditEmployee(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_edit_employee, null);

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
