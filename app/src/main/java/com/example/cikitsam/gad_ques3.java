package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class gad_ques3 extends AppCompatActivity {

    RadioGroup question3RadioGroup;
    Button prev,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gad_ques3);

        prev = findViewById(R.id.prev_2);
        next = findViewById(R.id.next_3);
        question3RadioGroup = findViewById(R.id.gad_test_3);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = question3RadioGroup.getCheckedRadioButtonId();
                String selectedOption = getSelectedOptionText(selectedOptionId);

                if(selectedOption.equals("No option selected") )
                {
                    Toast.makeText(gad_ques3.this, "No Option Selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("gad_3", selectedOption);
                    editor.apply();

                    Intent l = new Intent(gad_ques3.this, gad_ques4.class);
                    startActivity(l);
                }
            }

            private String getSelectedOptionText(int selectedOptionId) {
                RadioButton selectedRadioButton = findViewById(selectedOptionId);

                if (selectedRadioButton != null) {
                    // Retrieve the text of the selected RadioButton
                    return selectedRadioButton.getText().toString();
                } else {
                    // Handle the case where no option is selected or the ID is invalid
                    return "No option selected";
                }
            }
        });
    }
}