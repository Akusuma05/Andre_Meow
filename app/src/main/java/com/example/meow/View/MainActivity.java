package com.example.meow.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.example.meow.R;

public class MainActivity extends AppCompatActivity {

    NavHostFragment navHostFragment;

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.login_Fragment, R.id.registerFragment, R.id.dashboardFragment).build();
        navController = navHostFragment.getNavController();
    }
}