package com.rrudzinski.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when order button is pressed
     *
     * @param view
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean whippedCreamIsChecked = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "isChecked: " + whippedCreamIsChecked);

        displayMessage(createOrderSummary(5, whippedCreamIsChecked));
    }

    /**
     * Increments quantity by 1
     *
     * @param view
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * decrements quantity by 1
     *
     * @param view
     */
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * Displays order quantity
     *
     * @param number quantity of order
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Displays order information
     *
     * @param message text summary of order
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates price of the order
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create summary of the order
     *
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price, boolean checked) {
        String priceMessage = "Name: Rafal Rudzinski\n" + "Add whipped cream? " + checked +
                "\nQuantity: " + quantity + "\nTotal: $" + calculatePrice() + "\nThank You!";
        return priceMessage;
    }
}
