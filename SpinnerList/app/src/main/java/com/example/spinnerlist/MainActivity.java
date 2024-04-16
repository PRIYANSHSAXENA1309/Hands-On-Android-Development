package com.example.spinnerlist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView actxtView;
    ArrayList<String> arrIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        actxtView = findViewById(R.id.actxtView);

        arrIds.add("Aadhar Card");
        arrIds.add("Voter Id Card");
        arrIds.add("PAN Card");
        arrIds.add("Driving License Card");
        arrIds.add("Ration Card");
        arrIds.add("X score Card");
        arrIds.add("XII score Card");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrIds);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrIds);
        actxtView.setAdapter(actvAdapter);
        actxtView.setThreshold(2);
    }
}