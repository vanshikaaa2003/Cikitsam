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

public class Ques7hindi extends AppCompatActivity {
     Button next,prev;
     RadioGroup ques7hindiRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques7hindi);

        prev = findViewById(R.id.prevhindi7);
        next = findViewById(R.id.hindi7);
        ques7hindiRadioGroup = findViewById(R.id.queshindi7RadioGroup);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = ques7hindiRadioGroup.getCheckedRadioButtonId();
                String selectedOption = getSelectedOptionText(selectedOptionId);

                if(selectedOption.equals("No option selected") )
                {
                    Toast.makeText(Ques7hindi.this, "No Option Selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("question7hindi", selectedOption);
                    editor.apply();

                    Intent l = new Intent(Ques7hindi.this, Ques8hindi.class);
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