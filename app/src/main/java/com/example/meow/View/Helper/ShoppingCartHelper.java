package com.example.meow.View.Helper;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.meow.R;

public class ShoppingCartHelper {

    /**
     * Function Buat Keluarin Pop Up Shopping Cart
     *
     * Input: getContext(), getView()
     * Elements: back_button_shopping_cart, popupView
     * Output: popup_shoppingcart
     *
     * Usage: Fragment Dashboard, Order, Product, Categories, Employee
     * */
    public static void createPopUpShoppingCart(Context context, View layout) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_shoppingcart, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

        layout.post(new Runnable(){
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.RIGHT, 0, 0);
            }
        });

        //Back Button
        Button back_button_shopping_cart;
        back_button_shopping_cart = popupWindow.getContentView().findViewById(R.id.back_button_shopping_cart);
        back_button_shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        //Pop Up View
        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return false;
            }
        });
    }
}
