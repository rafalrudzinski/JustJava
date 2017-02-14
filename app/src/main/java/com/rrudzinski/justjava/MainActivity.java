package com.rrudzinski.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
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
        displayMessage(createOrderSummary(5, hasWhippedCream(), hasChocolate(), getName()));
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
        int basePrice = 5;

        if (hasWhippedCream()) {
            basePrice += 1;
        }

        if (hasChocolate()) {
            basePrice += 2;
        }

        return quantity * basePrice;
    }

    /**
     * Create summary of the order
     *
     * @param price of the order
     * @param addWhippedCream whether or not user wants whipped cream
     * @param addChocolate whether or not user wants chocolate
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String userName) {
        String priceMessage = "Name: " + userName +
                "\nAdd whipped cream? " + addWhippedCream +
                "\nAdd chocolate? " + addChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: $" + calculatePrice() +
                "\nThank You!";
        return priceMessage;
    }

    /**
     * Check if user chose to add whipped cream to order
     *
     * @return true if whipped cream was selected, false otherwise
     */
    private boolean hasWhippedCream() {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);

        return whippedCreamCheckBox.isChecked();
    }

    /**
     * Check if user chose to add chocolate to order
     *
     * @return true if chocolate was added, false otherwise
     */
    private boolean hasChocolate() {
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkBox);

        return chocolateCheckBox.isChecked();
    }

    /**
     * Get user's name entered in EditText field
     *
     * @return user's name
     */
    private String getName() {
        EditText nameFieldView = (EditText) findViewById(R.id.name_field);

        return nameFieldView.getText().toString();
    }
}
