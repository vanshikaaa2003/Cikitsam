package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import android.os.Handler;

import java.util.ArrayList;

public class Database_Connectivity extends AppCompatActivity {


    private TextView resultTextView;
    private ListView listView;
    private ArrayList<String> dataList;
    private CustomListAdapter adapter;
    private Handler handler = new Handler();
    private int currentIndex = 0;
    Button guide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_connectivity);

        resultTextView = findViewById(R.id.resultTextView);
        guide = findViewById(R.id.guide);
       // listView = findViewById(R.id.listView);
        dataList = new ArrayList<>();

        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(Database_Connectivity.this,Guidance.class);
                startActivity(n);
            }
        });
        // Execute the database operation in a background thread
        new DatabaseTask().execute();
    }
    private class DatabaseTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> resultData = new ArrayList<>();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://172.23.1.217:3306/result?connectTimeout=5000", "cikitsam", "cikitsam23");
                 Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT * FROM level");

                // Process the result set
                while (resultSet.next()) {
                   String rowData = "RESULT: " + resultSet.getString("classification") ;
//                            ", Name: " + resultSet.getString("name") +
//                            ", Username: " + resultSet.getString("username") +
//                            ", Password: " + resultSet.getString("password") +
//                            ", Gender: " + resultSet.getString("gender") +
//                            ", Roll No: " + resultSet.getString("rollno") +
//                            ", Class: " + resultSet.getString("class") +
//                            ", Marks: " + resultSet.getString("marks") +
//                            ", Board: " + resultSet.getString("board");

                    resultData.add(rowData);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                resultData.add("Error: " + e.getMessage());
            }

            return resultData;
        }

        @Override
        protected void onPostExecute(ArrayList<String> resultData) {
            // Update the TextView with the retrieved values

//            if (!resultData.isEmpty()) {
//                resultTextView.setText(resultData.get(0)); // Display the first item in TextView
//                resultData.remove(0); // Remove the first item (error or header)
//            }

            if (!resultData.isEmpty()) {
                resultTextView.setText(resultData.get(0)); // Display the first item in TextView
                resultData.remove(0); // Remove the first item (error or header)

                // Start displaying entries with a delay
                displayEntriesWithDelay(resultData);
            }

            // Update the ListView with the retrieved values
            dataList.addAll(resultData);
            adapter = new CustomListAdapter(Database_Connectivity.this, dataList);
            //listView.setAdapter(adapter);
        }
    }

    private void displayEntriesWithDelay(final ArrayList<String> entries) {
        final Handler handler = new Handler();
        final int delay = 2000; // milliseconds
        final int[] index = {0};

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index[0] < entries.size()) {
                    resultTextView.setText(entries.get(index[0]));
                    index[0]++;
                    handler.postDelayed(this, delay);
                }
            }
        }, delay);
    }
}