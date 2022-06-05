package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int num = 1;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = 100;
//        displayPrice(quantity * price);
        String priceMessage = quantity + " cups of coffee costs ₦" + (quantity * price);
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int castingQuantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String stringQuantity = Integer.toString(castingQuantity);
        quantityTextView.setText(stringQuantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        Locale nigeria = new Locale("en", "NG");
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance(nigeria).format(number));
    }

    /**
        This is a method to increase the quantity by 1
     */
    public void increment(View view) {
        quantity = quantity + num;
        displayQuantity(quantity);
    }

    /**
     This is a method to increase the quantity by 1
     */
    public void decrement(View view) {
        if (quantity > num) {
            quantity = quantity - num;
        } else {
            quantity = num;
        }

        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}