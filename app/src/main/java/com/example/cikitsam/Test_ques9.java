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

public class Test_ques9 extends AppCompatActivity {

    RadioGroup Testques9;
    Button submit,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ques9);

        prev = findViewById(R.id.preveight);
        submit = findViewById(R.id.submit);
        Testques9 = findViewById(R.id.test_ques_9_Rd);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = Testques9.getCheckedRadioButtonId();
                String selectedOption = getSelectedOptionText(selectedOptionId);


                if(selectedOption.equals("No option selected") )
                {
                    Toast.makeText(Test_ques9.this, "No Option Selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("test_ques9_res", selectedOption);
                    editor.apply();

                    Intent l = new Intent(Test_ques9.this, result_phq.class);
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