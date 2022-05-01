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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());

//        int quantity = 5;
        int price = 10;
        display(quantity);
        displayPrice(quantity * price);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String stringQuantity =Integer.toString(number);
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
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int num = 1;
        int castingQuantity = Integer.parseInt(quantityTextView.getText().toString()) + num;
        String stringQuantity =Integer.toString(castingQuantity);
        quantityTextView.setText(stringQuantity);
    }

    /**
     This is a method to increase the quantity by 1
     */
    public void decrement(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int num = 1;
        int castingQuantity = Integer.parseInt(quantityTextView.getText().toString());

        if (castingQuantity > num) {
            castingQuantity = Integer.parseInt(quantityTextView.getText().toString()) - num;
        } else {
            castingQuantity = num;
        }

        String stringQuantity =Integer.toString(castingQuantity);
        quantityTextView.setText(stringQuantity);
    }
}