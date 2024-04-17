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

public class Questionaire20 extends AppCompatActivity {
    RadioGroup question20RadioGroup;
     Button next,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire20);
        prev = findViewById(R.id.prevnint);
        next = findViewById(R.id.nexttwen);
        question20RadioGroup = findViewById(R.id.question20RadioGroup);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = question20RadioGroup.getCheckedRadioButtonId();
                String selectedOption = getSelectedOptionText(selectedOptionId);

                if(selectedOption.equals("No option selected") )
                {
                    Toast.makeText(Questionaire20.this, "No Option Selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("question20Result", selectedOption);
                    editor.apply();

                    Intent l = new Intent(Questionaire20.this, Questionaire21.class);
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