package com.example.meow.View.ActivityView.ViewModel;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.meow.Model.Dashboard;
import com.example.meow.View.CategoriesView.CategoriesFragmentDirections;
import com.example.meow.View.DashboardView.DashboardFragmentDirections;
import com.example.meow.View.EmployeeView.EmployeeFragmentDirections;
import com.example.meow.View.LoginView.LoginFragmentDirections;
import com.example.meow.View.OrderView.OrderFragmentDirections;
import com.example.meow.View.ProductView.ProductFragment;
import com.example.meow.View.ProductView.ProductFragmentDirections;

public class DashboardActivityViewModel extends ViewModel {

    /**
     * Function Buat Pindah Halaman di Dashboard Activity
     *
     * Input: Dashboard, getView()
     * Elements: navController, NavDirections
     * Output: Perpindahan Fragment di Dashboard Activity
     *
     * Usage: Dashboard Activity
     * */
    public void fragmentMovement(Dashboard dashboard, View view){
        NavDirections action;
        NavController navController = Navigation.findNavController(view);
        switch (dashboard.getCurrentPage()){
            case "dashboard":
                switch (dashboard.getNextPage()){
                    case "categories":
                        action = DashboardFragmentDirections.actionDashboardFragmentToCategoriesFragment();
                        navController.navigate(action);
                        break;
                    case "employee":
                        action = DashboardFragmentDirections.actionDashboardFragmentToEmployeeFragment();
                        navController.navigate(action);
                        break;
                    case "order":
                        action = DashboardFragmentDirections.actionDashboardFragmentToOrderFragment();
                        navController.navigate(action);
                        break;
                    case "product":
                        action = DashboardFragmentDirections.actionDashboardFragmentToProductFragment();
                        navController.navigate(action);
                        break;
                    default:
                        break;
                }
                break;
            case "categories":
                switch (dashboard.getNextPage()){
                    case "dashboard":
                        action = CategoriesFragmentDirections.actionCategoriesFragmentToDashboardFragment();
                        navController.navigate(action);
                        break;
                    case "employee":
                        action = CategoriesFragmentDirections.actionCategoriesFragmentToEmployeeFragment();
                        navController.navigate(action);
                        break;
                    case "order":
                        action = CategoriesFragmentDirections.actionCategoriesFragmentToOrderFragment();
                        navController.navigate(action);
                        break;
                    case "product":
                        action = CategoriesFragmentDirections.actionCategoriesFragmentToProductFragment();
                        navController.navigate(action);
                        break;
                    default:
                        break;
                }
                break;
            case "employee":
                switch (dashboard.getNextPage()){
                    case "dashboard":
                        action = EmployeeFragmentDirections.actionEmployeeFragmentToDashboardFragment();
                        navController.navigate(action);
                        break;
                    case "categories":
                        action = EmployeeFragmentDirections.actionEmployeeFragmentToCategoriesFragment();
                        navController.navigate(action);
                        break;
                    case "order":
                        action = EmployeeFragmentDirections.actionEmployeeFragmentToOrderFragment();
                        navController.navigate(action);
                        break;
                    case "product":
                        action = EmployeeFragmentDirections.actionEmployeeFragmentToProductFragment();
                        navController.navigate(action);
                        break;
                    default:
                        break;
                }
                break;
            case "order":
                switch (dashboard.getNextPage()){
                    case "dashboard":
                        action = OrderFragmentDirections.actionOrderFragmentToDashboardFragment();
                        navController.navigate(action);
                        break;
                    case "categories":
                        action = OrderFragmentDirections.actionOrderFragmentToCategoriesFragment();
                        navController.navigate(action);
                        break;
                    case "employee":
                        action = OrderFragmentDirections.actionOrderFragmentToEmployeeFragment();
                        navController.navigate(action);
                        break;
                    case "product":
                        action = OrderFragmentDirections.actionOrderFragmentToProductFragment();
                        navController.navigate(action);
                        break;
                    default:
                        break;
                }
                break;
            case "product":
                switch (dashboard.getNextPage()){
                    case "dashboard":
                        action = ProductFragmentDirections.actionProductFragmentToDashboardFragment();
                        navController.navigate(action);
                        break;
                    case "categories":
                        action = ProductFragmentDirections.actionProductFragmentToCategoriesFragment();
                        navController.navigate(action);
                        break;
                    case "employee":
                        action = ProductFragmentDirections.actionProductFragmentToEmployeeFragment();
                        navController.navigate(action);
                        break;
                    case "order":
                        action = ProductFragmentDirections.actionProductFragmentToOrderFragment();
                        navController.navigate(action);
                        break;
                    default:
                        break;
                }
                break;
        }
    }
}
