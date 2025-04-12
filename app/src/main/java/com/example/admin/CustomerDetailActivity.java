package com.example.admin;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

        // Back button
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());

        // Set data statistik
        TextView tvTotal = findViewById(R.id.tv_total_customers);
        TextView tvActive = findViewById(R.id.tv_active_customers);
        TextView tvNew = findViewById(R.id.tv_new_customers);

        tvTotal.setText("5.000");
        tvActive.setText("3.200");
        tvNew.setText("800");

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_customers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Customer> customers = getSampleCustomers();
        CustomerAdapter adapter = new CustomerAdapter(customers, this); // Tambahkan parameter context (this)
        recyclerView.setAdapter(adapter);
    }

    private List<Customer> getSampleCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", "john@example.com", "Aktif"));
        customers.add(new Customer("Jane Smith", "jane@example.com", "Aktif"));
        customers.add(new Customer("Robert Johnson", "robert@example.com", "Baru"));
        customers.add(new Customer("Emily Davis", "emily@example.com", "Aktif"));
        customers.add(new Customer("Michael Wilson", "michael@example.com", "Tidak Aktif"));
        return customers;
    }
}