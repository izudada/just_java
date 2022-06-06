package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        int price = calculatePrice();
//        String priceMessage = quantity + " cups of coffee costs\n" + "₦" + price;
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param *quantity is the number of cups of coffee ordered
     */
    private int calculatePrice() {
        return quantity * 5;
    }


    /**
     * Creates custom message for customer order summary
     *
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price) {
        String message = "Name: Anthony Udeagbaala\n";
        message += "Quantity: " + quantity + "\n";
        message += "Total: " + price + "\n";
        message += "Thank you!";
        return message;
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
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}