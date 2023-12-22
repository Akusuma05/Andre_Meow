package com.example.meow.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.meow.R;

public class DashboardActivity extends AppCompatActivity {

    NavHostFragment navHostFragment_dashboard;

    NavController navController_dashboard;
    LinearLayout dashboard_nav_menu, order_nav_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dashboard_nav_menu = findViewById(R.id.dashboard_nav_menu);
        order_nav_menu = findViewById(R.id.order_nav_menu);

        navHostFragment_dashboard = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView_dashboard);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.dashboardFragment).build();
        navController_dashboard = navHostFragment_dashboard.getNavController();

        order_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "Order", Toast.LENGTH_SHORT).show();
            }
        });

        dashboard_nav_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "DashBoard", Toast.LENGTH_SHORT).show();
            }
        });
    }
}