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

public class Questionaire1 extends AppCompatActivity {

    RadioGroup question1RadioGroup;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire1);
        next = findViewById(R.id.nextone);
        question1RadioGroup = findViewById(R.id.question1RadioGroup);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = question1RadioGroup.getCheckedRadioButtonId();
                String selectedOption = getSelectedOptionText(selectedOptionId);

                if(selectedOption.equals("No option selected") )
                {
                    Toast.makeText(Questionaire1.this, "No Option Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                  SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                  SharedPreferences.Editor editor = sharedPreferences.edit();
                  editor.putString("question1Result", selectedOption);
                  editor.apply();

                  Intent s = new Intent(Questionaire1.this,Questionaire2.class);
                  startActivity(s);
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