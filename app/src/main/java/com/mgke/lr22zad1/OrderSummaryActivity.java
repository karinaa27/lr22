package com.mgke.lr22zad1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        TextView orderSummaryTextView = findViewById(R.id.orderSummaryTextView);
        String orderSummary = getIntent().getStringExtra("ORDER_SUMMARY");
        orderSummaryTextView.setText(orderSummary);
    }
}
