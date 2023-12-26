package com.example.meow.View.DashboardView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
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

public class DashboardViewModel {

    /**
     * Function Buat Keluarin LineGraph
     *
     * Input: getView()
     * Elements: chart
     * Output: Isi dari chart
     *
     * Usage: Fragment Dashboard
     * */
    public static void createLineGraphDashboard(View view){
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
    }

    /**
     * Function Buat Keluarin PieChart
     *
     * Input: getView()
     * Elements: pie_chart
     * Output: Isi dari pie_chart
     *
     * Usage: Fragment Dashboard
     * */
    public static void createPieChartDashboard(View view){
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
    }

    /**
     * Function Buat Keluarin Table di Dashboard
     *
     * Input: getContext(), getView()
     * Elements: table
     * Output: content dari table
     *
     * Usage: Fragment Dashboard
     * */
    public static void createTableDashboard(View view, Context context){
        TableLayout table = view.findViewById(R.id.table);

        // Create a new table row for the column titles
        TableRow titleRow = new TableRow(context);
        titleRow.setPadding(32, 32, 32, 32); // Add padding to the row

        // Create the columns
        TextView no = new TextView(context);
        no.setText("No.");
        no.setTypeface(no.getTypeface(), Typeface.BOLD);
        titleRow.addView(no);

        TextView date = new TextView(context);
        date.setText("Date");
        date.setTypeface(date.getTypeface(), Typeface.BOLD);
        titleRow.addView(date);

        TextView time = new TextView(context);
        time.setText("Time");
        time.setTypeface(time.getTypeface(), Typeface.BOLD);
        titleRow.addView(time);

        TextView categories = new TextView(context);
        categories.setText("Categories");
        categories.setTypeface(categories.getTypeface(), Typeface.BOLD);
        titleRow.addView(categories);

        TextView products = new TextView(context);
        products.setText("Products");
        products.setTypeface(products.getTypeface(), Typeface.BOLD);
        titleRow.addView(products);

        TextView employee = new TextView(context);
        employee.setText("Employee");
        employee.setTypeface(employee.getTypeface(), Typeface.BOLD);
        titleRow.addView(employee);

        TextView paymentMethod = new TextView(context);
        paymentMethod.setText("Payment Method");
        paymentMethod.setTypeface(paymentMethod.getTypeface(), Typeface.BOLD);
        titleRow.addView(paymentMethod);

        TextView amount = new TextView(context);
        amount.setText("Amount");
        amount.setTypeface(amount.getTypeface(), Typeface.BOLD);
        titleRow.addView(amount);

        // Add the title row to the table
        table.addView(titleRow);

        // Add a line after each row
        View line = new View(context);
        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        line.setBackgroundColor(Color.DKGRAY);
        table.addView(line);

        // Add dummy data
        for (int i = 1; i <= 10; i++) {
            // Create a new table row
            TableRow row = new TableRow(context);
            row.setPadding(32, 32, 32, 32); // Add padding to the row

            // Create the columns
            TextView no1 = new TextView(context);
            no1.setText(String.valueOf(i));
            row.addView(no1);

            TextView date1 = new TextView(context);
            date1.setText("23/12/2023");
            row.addView(date1);

            TextView time1 = new TextView(context);
            time1.setText("10:30 AM");
            row.addView(time1);

            TextView categories1 = new TextView(context);
            categories1.setText("Category " + i);
            row.addView(categories1);

            TextView products1 = new TextView(context);
            products1.setText("Product " + i);
            row.addView(products1);

            TextView employee1 = new TextView(context);
            employee1.setText("Employee " + i);
            row.addView(employee1);

            TextView paymentMethod1 = new TextView(context);
            paymentMethod1.setText("Payment Method " + i);
            row.addView(paymentMethod1);

            TextView amount1 = new TextView(context);
            amount1.setText(String.valueOf(1500 + i));
            row.addView(amount1);

            // Add the row to the table
            table.addView(row);

            // Add a line after each row
            View line1 = new View(context);
            line1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
            line1.setBackgroundColor(Color.DKGRAY);
            table.addView(line1);
        }
    }
}
