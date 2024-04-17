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

public class Test_ques8 extends AppCompatActivity {

    RadioGroup Testques8;
    Button next,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ques8);

        prev = findViewById(R.id.prevseven);
        next = findViewById(R.id.nexteight);
        Testques8 = findViewById(R.id.test_ques_8_Rd);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = Testques8.getCheckedRadioButtonId();
                String selectedOption = getSelectedOptionText(selectedOptionId);


                if(selectedOption.equals("No option selected") )
                {
                    Toast.makeText(Test_ques8.this, "No Option Selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("test_ques8_res", selectedOption);
                    editor.apply();

                    Intent l = new Intent(Test_ques8.this,Test_ques9.class);
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