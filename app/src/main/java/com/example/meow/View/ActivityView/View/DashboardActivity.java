package com.example.meow.View.ActivityView.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.meow.Model.Dashboard;
import com.example.meow.R;
import com.example.meow.View.ActivityView.ViewModel.DashboardActivityViewModel;

public class DashboardActivity extends AppCompatActivity {

    NavHostFragment navHostFragment_dashboard;

    NavController navController_dashboard;
    LinearLayout dashboard_nav_menu, order_nav_menu, products_nav_menu, categories_nav_menu, employee_nav_menu;
    Dashboard dashboard = new Dashboard("dashboard", "");
    DashboardActivityViewModel dashboardActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dashboard_nav_menu = findViewById(R.id.dashboard_nav_menu);
        order_nav_menu = findViewById(R.id.order_nav_menu);
        products_nav_menu = findViewById(R.id.products_nav_menu);
        categories_nav_menu = findViewById(R.id.categories_nav_menu);
        employee_nav_menu = findViewById(R.id.employee_nav_menu);

        navHostFragment_dashboard = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView_dashboard);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.dashboardFragment,R.id.orderFragment,R.id.productFragment,R.id.employeeFragment, R.id.categoriesFragment
        ).build();
        navController_dashboard = navHostFragment_dashboard.getNavController();

        dashboardActivityViewModel = new ViewModelProvider(this).get(DashboardActivityViewModel.class);

        order_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboard_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                products_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                categories_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                employee_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                order_nav_menu.setBackgroundResource(R.drawable.customborderselect);
                dashboard.setNextPage("order");
                dashboardActivityViewModel.fragmentMovement(dashboard, findViewById(R.id.fragmentContainerView_dashboard));
                dashboard.setCurrentPage("order");
                dashboard.setNextPage("");
                Toast.makeText(DashboardActivity.this, "Order", Toast.LENGTH_SHORT).show();
            }
        });

        dashboard_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                products_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                categories_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                employee_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                dashboard_nav_menu.setBackgroundResource(R.drawable.customborderselect);
                dashboard.setNextPage("dashboard");
                dashboardActivityViewModel.fragmentMovement(dashboard, findViewById(R.id.fragmentContainerView_dashboard));
                dashboard.setCurrentPage("dashboard");
                dashboard.setNextPage("");
                Toast.makeText(DashboardActivity.this, "DashBoard", Toast.LENGTH_SHORT).show();
            }
        });

        products_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                dashboard_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                categories_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                employee_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                products_nav_menu.setBackgroundResource(R.drawable.customborderselect);
                dashboard.setNextPage("product");
                dashboardActivityViewModel.fragmentMovement(dashboard, findViewById(R.id.fragmentContainerView_dashboard));
                dashboard.setCurrentPage("product");
                dashboard.setNextPage("");
                Toast.makeText(DashboardActivity.this, "Products", Toast.LENGTH_SHORT).show();
            }
        });

        categories_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                dashboard_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                products_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                employee_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                categories_nav_menu.setBackgroundResource(R.drawable.customborderselect);
                dashboard.setNextPage("categories");
                dashboardActivityViewModel.fragmentMovement(dashboard, findViewById(R.id.fragmentContainerView_dashboard));
                dashboard.setCurrentPage("categories");
                dashboard.setNextPage("");
                Toast.makeText(DashboardActivity.this, "Categories", Toast.LENGTH_SHORT).show();
            }
        });

        employee_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                dashboard_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                products_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                categories_nav_menu.setBackgroundColor(Color.TRANSPARENT);
                employee_nav_menu.setBackgroundResource(R.drawable.customborderselect);
                dashboard.setNextPage("employee");
                dashboardActivityViewModel.fragmentMovement(dashboard, findViewById(R.id.fragmentContainerView_dashboard));
                dashboard.setCurrentPage("employee");
                dashboard.setNextPage("");
                Toast.makeText(DashboardActivity.this, "Employees", Toast.LENGTH_SHORT).show();
            }
        });

    }
}