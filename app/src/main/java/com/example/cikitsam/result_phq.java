package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result_phq extends AppCompatActivity {

    TextView stressedit,anedit,deedit;
    int depression=0;
    String dep;
    Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_phq);
        stressedit = findViewById(R.id.stressedit);
        anedit = findViewById(R.id.anedit);
        deedit = findViewById(R.id.deedit);
        test = findViewById(R.id.assistance);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String question1Result = sharedPreferences.getString("test_ques1_res", "");
        String question2Result = sharedPreferences.getString("test_ques2_res", "");
        String question3Result = sharedPreferences.getString("test_ques3_res", "");
        String question4Result = sharedPreferences.getString("test_ques4_res", "");
        String question5Result = sharedPreferences.getString("test_ques5_res", "");
        String question6Result = sharedPreferences.getString("test_ques6_res", "");
        String question7Result = sharedPreferences.getString("test_ques7_res", "");
        String question8Result = sharedPreferences.getString("test_ques8_res", "");
        String question9Result = sharedPreferences.getString("test_ques9_res", "");
        String Stress = sharedPreferences.getString("stress", "");
        String Anxiety = sharedPreferences.getString("anxiety", "");

        if(question1Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question1Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question1Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question2Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question2Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question2Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question3Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question3Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question3Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question4Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question4Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question4Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question5Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question5Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question5Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question6Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question6Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question6Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question7Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question7Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question7Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question8Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question8Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question8Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }

        if(question9Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question9Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question9Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }


        if(depression>=1 && depression<=9 )
        {
            deedit.setText("DEPRESSSION - MINIMAL");

            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depress","MINIMAL");
            editor.apply();
        }
        else if(depression>=10 && depression<=13 )
        {
            deedit.setText("DEPRESSSION - MILD");

            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depress","MILD");
            editor.apply();
        }
        else if(depression>=14 && depression<=20 )
        {
            deedit.setText("DEPRESSSION - MODERATE");

            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depress","MODERATE");
            editor.apply();
        }
        else if(depression>=21 && depression<=27 )
        {
            deedit.setText("DEPRESSSION - MODERATELY SEVERE");

            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depress","MODERATELY SEVERE");
            editor.apply();
        }
        else  if(depression>=28 )
        {
            deedit.setText("DEPRESSSION - SEVERE");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depress","SEVERE");
            editor.apply();
        }


        stressedit.setText("STRESS - "+Stress);
        anedit.setText("ANXIETY - "+Anxiety);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(result_phq.this, Gad_ques1.class);
                startActivity(l);
            }
        });
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // This will finish the current activity and remove it from the back stack
    }
}