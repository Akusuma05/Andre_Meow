package com.example.meow.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.example.meow.R;

public class DashboardActivity extends AppCompatActivity {

    NavHostFragment navHostFragment_dashboard;

    NavController navController_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        navHostFragment_dashboard = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView_dashboard);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.dashboardFragment).build();
        navController_dashboard = navHostFragment_dashboard.getNavController();

    }
}