package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;
    TextView stressedit,anedit,deedit;
    String dep;
    Button Test,Remedy,Test2;
    int stress=0,depression=0,anxiety=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Test = findViewById(R.id.testt);
        Test2 = findViewById(R.id.testan);
        Remedy = findViewById(R.id.remedy);

        stressedit = findViewById(R.id.stressedit);
        anedit = findViewById(R.id.anedit);
        deedit = findViewById(R.id.deedit);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String question1Result = sharedPreferences.getString("question1Result", "");
        String question2Result = sharedPreferences.getString("question2Result", "");
        String question3Result = sharedPreferences.getString("question3Result", "");
        String question4Result = sharedPreferences.getString("question4Result", "");
        String question5Result = sharedPreferences.getString("question5Result", "");
        String question6Result = sharedPreferences.getString("question6Result", "");
        String question7Result = sharedPreferences.getString("question7Result", "");
        String question8Result = sharedPreferences.getString("question8Result", "");
        String question9Result = sharedPreferences.getString("question9Result", "");
        String question10Result = sharedPreferences.getString("question10Result", "");
        String question11Result = sharedPreferences.getString("question11Result", "");
        String question12Result = sharedPreferences.getString("question12Result", "");
        String question13Result = sharedPreferences.getString("question13Result", "");
        String question14Result = sharedPreferences.getString("question14Result", "");
        String question15Result = sharedPreferences.getString("question15Result", "");
        String question16Result = sharedPreferences.getString("question16Result", "");
        String question17Result = sharedPreferences.getString("question17Result", "");
        String question18Result = sharedPreferences.getString("question18Result", "");
        String question19Result = sharedPreferences.getString("question19Result", "");
        String question20Result = sharedPreferences.getString("question20Result", "");
        String question21Result = sharedPreferences.getString("question21Result", "");
        if(question1Result.equals("Always"))
        {
            stress = stress + 3;

        }
        else if(question1Result.equals("Often"))
        {
            stress = stress + 2;
        }
        else if(question1Result.equals("Sometimes"))
        {
              stress = stress + 1;
        }
        if(question2Result.equals("Always"))
        {
            stress = stress + 3;
        }
        else if(question2Result.equals("Often"))
        {
            stress = stress + 2;
        }
        else if(question2Result.equals("Sometimes"))
        {
            stress = stress + 1;
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
        if(question8Result.equals("Always"))
        {
            stress = stress + 3;
        }
        else if(question8Result.equals("Often"))
        {
            stress = stress + 2;
        }
        else if(question8Result.equals("Sometimes"))
        {
            stress = stress + 1;
        }
        if(question9Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question9Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question9Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question10Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question10Result.equals("Often"))
        {
            depression = depression+ 2;
        }
        else if(question10Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }
        if(question11Result.equals("Always"))
        {
            stress = stress + 3;
        }
        else if(question11Result.equals("Often"))
        {
            stress = stress + 2;
        }
        else if(question11Result.equals("Sometimes"))
        {
            stress = stress + 1;
        }
        if(question12Result.equals("Always"))
        {
            stress = stress + 3;
        }
        else if(question12Result.equals("Often"))
        {
            stress = stress + 2;
        }
        else if(question12Result.equals("Sometimes"))
        {
            stress = stress + 1;
        }
        if(question13Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question13Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question13Result.equals("Sometimes"))
        {
           depression = depression + 1;
        }
        if(question14Result.equals("Always"))
        {
            stress = stress + 3;
        }
        else if(question14Result.equals("Often"))
        {
            stress = stress + 2;
        }
        else if(question14Result.equals("Sometimes"))
        {
            stress = stress + 1;
        }
        if(question15Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question15Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question15Result.equals("Sometimes"))
        {
            anxiety = anxiety+ 1;
        }
        if(question16Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question16Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question16Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }
        if(question17Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question17Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question17Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }
        if(question18Result.equals("Always"))
        {
            stress = stress + 3;
        }
        else if(question18Result.equals("Often"))
        {
            stress = stress + 2;
        }
        else if(question18Result.equals("Sometimes"))
        {
            stress = stress + 1;
        }
        if(question19Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question19Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question19Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question20Result.equals("Always"))
        {
            anxiety = anxiety + 3;
        }
        else if(question20Result.equals("Often"))
        {
            anxiety = anxiety + 2;
        }
        else if(question20Result.equals("Sometimes"))
        {
            anxiety = anxiety + 1;
        }
        if(question21Result.equals("Always"))
        {
            depression = depression + 3;
        }
        else if(question21Result.equals("Often"))
        {
            depression = depression + 2;
        }
        else if(question21Result.equals("Sometimes"))
        {
            depression = depression + 1;
        }



        if(anxiety>=0 && anxiety<=7 )
        {
            anedit.setText("NORMAL");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("anxiety","NORMAL");
            editor.apply();
        }
        else if(anxiety>=8 && anxiety<=9 )
        {
            anedit.setText("MILD");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("anxiety","MILD");
            editor.apply();
        }
        else if(anxiety>=10 && anxiety<=14 )
        {
            anedit.setText("MODERATE");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("anxiety","MODERATE");
            editor.apply();
        }
        else if(anxiety>=15 && anxiety<=19 )
        {
            anedit.setText(" SEVERE");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("anxiety","SEVERE");
            editor.apply();
        }
        else  if(anxiety>=20 )
        {
            anedit.setText("EXTREMELY SEVERE");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("anxiety","EXTREMELY SEVERE");
            editor.apply();
        }



        if(stress>=0 && stress<=14 )
        {
            stressedit.setText("NORMAL");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("stress","NORMAL");
            editor.apply();
        }
        else if(stress>=15 && stress<=18 )
        {
            stressedit.setText("MILD");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("stress","MILD");
            editor.apply();
        }
        else if(stress>=19 && stress<=25 )
        {
            stressedit.setText("MODERATE");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("stress","MODERATE");
            editor.apply();
        }
        else if(stress>=26 && stress<=33 )
        {
            stressedit.setText("SEVERE");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("stress","SEVERE");
            editor.apply();
        }
        else  if(stress>=34 )
        {
            stressedit.setText("EXTREMELY SEVERE");
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("stress","EXTREMELY SEVERE");
            editor.apply();
        }


        if(depression>=0 && depression<=9 )
        {
            deedit.setText("NORMAL");
            dep = "NORMAL";
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depression","NORMAL");
            editor.apply();
        }
        else if(depression>=10 && depression<=13 )
        {
            deedit.setText("MILD");
            dep = "MILD";
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depression","MILD");
            editor.apply();
        }
        else if(depression>=14 && depression<=20 )
        {
            deedit.setText("MODERATE");
            dep="MODERATE";
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depression","MODERATE");
            editor.apply();
        }
        else if(depression>=21 && depression<=27 )
        {
            deedit.setText("SEVERE");
            dep="SEVERE";
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depression","SEVERE");
            editor.apply();
        }
        else  if(depression>=28 )
        {
            deedit.setText("EXTREMELY SEVERE");
            dep = "EXTREMELY SEVERE";
            SharedPreferences sharedPreferencess = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencess.edit();
            editor.putString("depression","EXTREMELY SEVERE");
            editor.apply();
        }

        Remedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(ResultActivity.this,NNN.class);
                startActivity(k);
            }
        });
        //further test conduct depression
       /* if(depression>=14)
        {
            Test.setVisibility(View.VISIBLE);
            Test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(depression>=14)
                    {
                        Intent k = new Intent(ResultActivity.this,Test_ques1.class);
                        startActivity(k);
                    }
                }
            });
        }
        else
        {
          Remedy.setVisibility(View.VISIBLE);
        }

        //further test for anxiety if depression in also high

        if(anxiety>=15)
        {
            Test2.setVisibility(View.VISIBLE);
            Test2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    {
                        Intent k = new Intent(ResultActivity.this,Gad_ques1.class);
                        startActivity(k);
                    }
                }
            });
        }*/
        }

    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // This will finish the current activity and remove it from the back stack
    }

}