package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Past_History extends AppCompatActivity {

    private Button showDatePickerButton;
    private ListView healthListView;
    private ArrayList<String> healthData;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_history);

        showDatePickerButton = findViewById(R.id.showDatePickerButton);
        healthListView = findViewById(R.id.healthListView);

        // Hardcoded health data for demonstration
        healthData = new ArrayList<>();
        healthData.add("STRESS - SEVERE");
        healthData.add("ANXIETY - MODERATE");
        healthData.add("DEPRESSION - NORMAL");

        // Using ArrayAdapter with a custom layout
        adapter = new ArrayAdapter<>(this, R.layout.list_item_health_data, R.id.healthDataTextView, healthData);

        // Display health data in ListView
        healthListView.setAdapter(adapter);

        // Set a listener for item click
        healthListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(Past_History.this, "Selected Health Data: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        // Set a listener for the button to show the date picker dialog
        showDatePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Handle date selection and update health data as needed
                        healthData.clear();
                        healthData.add("Heart rate: 75 bpm");
                        healthData.add("Blood pressure: 130/85 mmHg");
                        healthData.add("Weight: 71 kg");
                        adapter.notifyDataSetChanged();
                    }
                },
                year, month, day);

        datePickerDialog.show();
    }
}