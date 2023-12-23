package com.example.meow.View.DashboardView;

import android.graphics.Typeface;
import android.os.Bundle;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.meow.R;
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
        TextView title = view.findViewById(R.id.title);
        LineChart chart = view.findViewById(R.id.chart);

        // Create some dummy data for the chart
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 10));
        entries.add(new Entry(2, 15));
        entries.add(new Entry(3, 12));
        entries.add(new Entry(4, 18));
        entries.add(new Entry(5, 14));
        entries.add(new Entry(6, 16));
        entries.add(new Entry(7, 20));

        // Create a line dataset from the entries
        LineDataSet dataSet = new LineDataSet(entries, "Values");
        dataSet.setColor(Color.BLUE);
        dataSet.setCircleColor(Color.BLUE);
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(4f);

        // Create a line data object from the dataset
        LineData lineData = new LineData(dataSet);

        // Set the data for the chart
        chart.setData(lineData);

        // Customize the chart appearance
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setDrawGridBackground(false);

        // Customize the x axis
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                String day = "";
                switch ((int) value) {
                    case 1:
                        day = "Mon";
                        break;
                    case 2:
                        day = "Tues";
                        break;
                    case 3:
                        day = "Wed";
                        break;
                    case 4:
                        day = "Thurs";
                        break;
                    case 5:
                        day = "Fri";
                        break;
                    case 6:
                        day = "Sat";
                        break;
                    case 7:
                        day = "Sun";
                        break;
                }
                return day;
            }
        });

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setDrawGridLines(false);

        // Disable the right y axis
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

        // Refresh the chart
        chart.invalidate();

        PieChart pieChart = view.findViewById(R.id.pie_chart);

        List<PieEntry> entriesPie = new ArrayList<>();
        entriesPie.add(new PieEntry(18.5f, "Green"));
        entriesPie.add(new PieEntry(26.7f, "Yellow"));
        entriesPie.add(new PieEntry(24.0f, "Red"));
        entriesPie.add(new PieEntry(30.8f, "Blue"));

        PieDataSet set = new PieDataSet(entriesPie, "");
        set.setColors(Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE);

        // Get the description of the PieChart
        Description description = pieChart.getDescription();

        // Disable the description
        description.setEnabled(false);

        PieData data = new PieData(set);

        // Disable the values
        data.setDrawValues(false);

        // Set the data for the chart
        pieChart.setData(data);

        // Disable the entry labels
        pieChart.setDrawEntryLabels(false);

        // Refresh the chart
        pieChart.invalidate();
        // refresh

        TableLayout table = view.findViewById(R.id.table);

        // Create a new table row for the column titles
        TableRow titleRow = new TableRow(getContext());
        titleRow.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView no = new TextView(getContext());
        no.setText("No.");
        no.setTypeface(no.getTypeface(), Typeface.BOLD);
        titleRow.addView(no);

        TextView date = new TextView(getContext());
        date.setText("Date");
        date.setTypeface(date.getTypeface(), Typeface.BOLD);
        titleRow.addView(date);

        TextView time = new TextView(getContext());
        time.setText("Time");
        time.setTypeface(time.getTypeface(), Typeface.BOLD);
        titleRow.addView(time);

        TextView categories = new TextView(getContext());
        categories.setText("Categories");
        categories.setTypeface(categories.getTypeface(), Typeface.BOLD);
        titleRow.addView(categories);

        TextView products = new TextView(getContext());
        products.setText("Products");
        products.setTypeface(products.getTypeface(), Typeface.BOLD);
        titleRow.addView(products);

        TextView employee = new TextView(getContext());
        employee.setText("Employee");
        employee.setTypeface(employee.getTypeface(), Typeface.BOLD);
        titleRow.addView(employee);

        TextView paymentMethod = new TextView(getContext());
        paymentMethod.setText("Payment Method");
        paymentMethod.setTypeface(paymentMethod.getTypeface(), Typeface.BOLD);
        titleRow.addView(paymentMethod);

        TextView amount = new TextView(getContext());
        amount.setText("Amount");
        amount.setTypeface(amount.getTypeface(), Typeface.BOLD);
        titleRow.addView(amount);

        // Add the title row to the table
        table.addView(titleRow);

        // Add a line after each row
        View line = new View(getContext());
        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line.setBackgroundColor(Color.DKGRAY);
        table.addView(line);

        // Add dummy data
        for (int i = 1; i <= 10; i++) {
            // Create a new table row
            TableRow row = new TableRow(getContext());
            row.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView no1 = new TextView(getContext());
            no1.setText(String.valueOf(i));
            row.addView(no1);

            TextView date1 = new TextView(getContext());
            date1.setText("23/12/2023");
            row.addView(date1);

            TextView time1 = new TextView(getContext());
            time1.setText("10:30 AM");
            row.addView(time1);

            TextView categories1 = new TextView(getContext());
            categories1.setText("Category " + i);
            row.addView(categories1);

            TextView products1 = new TextView(getContext());
            products1.setText("Product " + i);
            row.addView(products1);

            TextView employee1 = new TextView(getContext());
            employee1.setText("Employee " + i);
            row.addView(employee1);

            TextView paymentMethod1 = new TextView(getContext());
            paymentMethod1.setText("Payment Method " + i);
            row.addView(paymentMethod1);

            TextView amount1 = new TextView(getContext());
            amount1.setText(String.valueOf(1500 + i));
            row.addView(amount1);

            // Add the row to the table
            table.addView(row);

            // Add a line after each row
            View line1 = new View(getContext());
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table.addView(line1);
        }


    }
}