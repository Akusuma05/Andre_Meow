package com.example.meow.View.EmployeeView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meow.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeFragment newInstance(String param1, String param2) {
        EmployeeFragment fragment = new EmployeeFragment();
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
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TableLayout table_active_employee = view.findViewById(R.id.table_active_employee);
        TableLayout table_pending_employee = view.findViewById(R.id.table_pending_employee);

        // Create a new table row for the column titles
        TableRow tableActiveEmployee = new TableRow(getContext());
        tableActiveEmployee.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView name = new TextView(getContext());
        name.setText("Name");
        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        tableActiveEmployee.addView(name);

        TextView phone = new TextView(getContext());
        phone.setText("Phone Number");
        phone.setTypeface(phone.getTypeface(), Typeface.BOLD);
        tableActiveEmployee.addView(phone);

        TextView action = new TextView(getContext());
        action.setText("Action");
        action.setTypeface(action.getTypeface(), Typeface.BOLD);
        tableActiveEmployee.addView(action);

        // Add the title row to the table
        table_active_employee.addView(tableActiveEmployee);

        // Add a line after each row
        View line = new View(getContext());
        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line.setBackgroundColor(Color.DKGRAY);
        table_active_employee.addView(line);

        for (int i = 1; i <= 10; i++) {
            // Create a new table row for the column titles
            TableRow tableActiveEmployeeContent = new TableRow(getContext());
            tableActiveEmployeeContent.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView name1 = new TextView(getContext());
            name1.setText("Name" + i);
            tableActiveEmployeeContent.addView(name1);

            // Create the columns
            TextView phone1 = new TextView(getContext());
            phone1.setText(String.valueOf(i));
            tableActiveEmployeeContent.addView(phone1);

            LinearLayout iconColumn = new LinearLayout(getContext());
            iconColumn.setOrientation(LinearLayout.HORIZONTAL);

            ImageView icon1 = new ImageView(getContext());
            icon1.setImageResource(R.drawable.edit);
            icon1.setPadding(16, 16, 16, 16);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Icon 1 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon1);

            ImageView icon2 = new ImageView(getContext());
            icon2.setImageResource(R.drawable.delete);
            icon2.setPadding(16, 16, 16, 16);
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Icon 2 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon2);

            tableActiveEmployeeContent.addView(iconColumn);

            // Add the row to the table
            table_active_employee.addView(tableActiveEmployeeContent);

            // Add a line after each row
            View line1 = new View(getContext());
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table_active_employee.addView(line1);
        }


        // Create a new table row for the column titles
        TableRow tablePendingEmployee = new TableRow(getContext());
        tablePendingEmployee.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView name3 = new TextView(getContext());
        name3.setText("Name");
        name3.setTypeface(name3.getTypeface(), Typeface.BOLD);
        tablePendingEmployee.addView(name3);

        TextView phone3 = new TextView(getContext());
        phone3.setText("Phone Number");
        phone3.setTypeface(phone3.getTypeface(), Typeface.BOLD);
        tablePendingEmployee.addView(phone3);

        TextView action3 = new TextView(getContext());
        action3.setText("Action");
        action3.setTypeface(action3.getTypeface(), Typeface.BOLD);
        tablePendingEmployee.addView(action3);

        // Add the title row to the table
        table_pending_employee.addView(tablePendingEmployee);

        // Add a line after each row
        View line2 = new View(getContext());
        line2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line2.setBackgroundColor(Color.DKGRAY);
        table_pending_employee.addView(line2);

        for (int i = 1; i <= 10; i++) {
            // Create a new table row for the column titles
            TableRow tablePendingEmployeeContent = new TableRow(getContext());
            tablePendingEmployeeContent.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView name1 = new TextView(getContext());
            name1.setText("Name" + i);
            tablePendingEmployeeContent.addView(name1);

            // Create the columns
            TextView phone1 = new TextView(getContext());
            phone1.setText(String.valueOf(i));
            tablePendingEmployeeContent.addView(phone1);

            LinearLayout iconColumn = new LinearLayout(getContext());
            iconColumn.setOrientation(LinearLayout.HORIZONTAL);

            ImageView icon1 = new ImageView(getContext());
            icon1.setImageResource(R.drawable.check_box);
            icon1.setPadding(16, 16, 16, 16);
            icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Icon 1 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon1);

            ImageView icon2 = new ImageView(getContext());
            icon2.setImageResource(R.drawable.cross_box);
            icon2.setPadding(16, 16, 16, 16);
            icon2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Icon 2 in " + name1.getText() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
            iconColumn.addView(icon2);

            tablePendingEmployeeContent.addView(iconColumn);

            // Add the row to the table
            table_pending_employee.addView(tablePendingEmployeeContent);

            // Add a line after each row
            View line1 = new View(getContext());
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table_pending_employee.addView(line1);
        }
    }
}