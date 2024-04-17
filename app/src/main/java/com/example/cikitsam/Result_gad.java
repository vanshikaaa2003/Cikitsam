package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Result_gad extends AppCompatActivity {

    TextView stressedit,anedit,deedit;
    int anxiety=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_gad);
        stressedit = findViewById(R.id.stressval);
        anedit = findViewById(R.id.anval);
        deedit = findViewById(R.id.deval);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String question1Result = sharedPreferences.getString("gad_1", "");
        String question2Result = sharedPreferences.getString("gad_2", "");
        String question3Result = sharedPreferences.getString("gad_3", "");
        String question4Result = sharedPreferences.getString("gad_4", "");
        String question5Result = sharedPreferences.getString("gad_5", "");
        String question6Result = sharedPreferences.getString("gad_6", "");
        String question7Result = sharedPreferences.getString("gad_7", "");

        String Stress = sharedPreferences.getString("stress", "");
        String Depression = sharedPreferences.getString("depress", "");

        if(question1Result.equals("Always"))
        {
            anxiety = anxiety + 3;

        }
        else if(question1Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question1Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question2Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question2Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question2Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question3Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question3Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question3Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question4Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question4Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question4Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question5Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question5Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question5Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question6Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question6Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question6Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question7Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question7Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question7Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }

        if(anxiety>=0 && anxiety<=4)
        {
            anedit.setText("ANXIETY - MINIMAL");
        }
        else if(anxiety>=5 && anxiety<=9 )
        {
            anedit.setText("ANXIETY - MILD");
        }
        else if(anxiety>=10 && anxiety<=14 )
        {
            anedit.setText("ANXIETY - MODERATE");
        }
        else if(anxiety>=15 && anxiety<=21 )
        {
            anedit.setText("ANXIETY - SEVERE");
        }

        stressedit.setText("STRESS - "+Stress);
        deedit.setText("DEPRESSION - "+Depression);
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // This will finish the current activity and remove it from the back stack
    }
}