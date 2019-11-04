package com.example.android.papers;


import java.text.NumberFormat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int a=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text=(EditText) findViewById(R.id.edit_text_view);
        String name=text.getText().toString();
        EditText text1=(EditText) findViewById(R.id.edit1_text_view);
        String name1=text1.getText().toString();
        EditText text2=(EditText) findViewById(R.id.edit2_text_view);
        String name2=text2.getText().toString();
        CheckBox bubbleWrapCheckBox=(CheckBox) findViewById(R.id.Bubble_wrap_checkbox);
        boolean hasBubblewrap=bubbleWrapCheckBox.isChecked();
        CheckBox paperWrapCheckBox=(CheckBox) findViewById(R.id.Paper_wrap_checkbox);
        boolean hasPaperwrap=paperWrapCheckBox.isChecked();


        int price=calculatePrice(hasBubblewrap,hasPaperwrap);
        String priceMessage=createOrderSummary(name,name1,name2,price,hasBubblewrap,hasPaperwrap);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT,"Order for:" +name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayMessage(priceMessage);


    }
    private int calculatePrice(boolean hasBubblewrap,boolean hasPaperwrap){
        int baseprice=25;
        if(hasBubblewrap){
            baseprice+=8;

        }
        if(hasPaperwrap){
            baseprice+=4;

        }


        return baseprice*a;


    }
    private String createOrderSummary(String name,String name1,String name2,int price,boolean hasBubblewrap,boolean hasPpaerwrap){
        String priceMessage="Name: " +name;
        priceMessage+="\nPick up address: " +name1;
        priceMessage+="\nDelivery address: " +name2;
        priceMessage+="\nTotal Rs." + price;
        priceMessage+="\nWeight: " +a;
        priceMessage+="\nHas Bubble wrap? " + hasBubblewrap;
        priceMessage+="\nHas Paper wrap? " + hasPpaerwrap;
        priceMessage=priceMessage + "\nThank You for joining with us!";

        return priceMessage;
    }
    public void increment(View view) {
        if (a == 3){
            return;
        }
        a = a + 1;

        display(a);

    }
    public void decrement(View view) {

        if(a==1){
            return;
        }
        a = a - 1;

        display(a);

    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}

