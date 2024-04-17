package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Questionaire2 extends AppCompatActivity {
    RadioGroup question2RadioGroup;
    Button prev,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire2);
        prev = findViewById(R.id.prevone);
        next = findViewById(R.id.nexttwo);
        question2RadioGroup = findViewById(R.id.question2RadioGroup);

        // Set the RadioGroup to the previously selected option, if it exists
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = question2RadioGroup.getCheckedRadioButtonId();
                String selectedOption = getSelectedOptionText(selectedOptionId);


                if(selectedOption.equals("No option selected") )
                {
                    Toast.makeText(Questionaire2.this, "No Option Selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("question2Result", selectedOption);
                    editor.apply();

                    Intent l = new Intent(Questionaire2.this, Questionaire3.class);
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