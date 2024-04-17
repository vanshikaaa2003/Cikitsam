package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultHindi extends AppCompatActivity {

    TextView resultTextView;
    TextView stressedit, anedit, deedit;
    Button Test, Remedy, Test2;
    int stress = 0, depression = 0, anxiety = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_hindi);
        stressedit = findViewById(R.id.stressedit);
        anedit = findViewById(R.id.anedit);
        deedit = findViewById(R.id.deedit);
        Test = findViewById(R.id.testone);
        Test2 = findViewById(R.id.testtwo);
        Remedy = findViewById(R.id.remedies);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String question1Result = sharedPreferences.getString("question1hindi", "");
        String question2Result = sharedPreferences.getString("question2hindi", "");
        String question3Result = sharedPreferences.getString("question3hindi", "");
        String question4Result = sharedPreferences.getString("question4hindi", "");
        String question5Result = sharedPreferences.getString("question5hindi", "");
        String question6Result = sharedPreferences.getString("question6hindi", "");
        String question7Result = sharedPreferences.getString("question7hindi", "");
        String question8Result = sharedPreferences.getString("question8hindi", "");
        String question9Result = sharedPreferences.getString("question9hindi", "");
        String question10Result = sharedPreferences.getString("question10hindi", "");
        String question11Result = sharedPreferences.getString("question11hindi", "");
        String question12Result = sharedPreferences.getString("question12hindi", "");
        String question13Result = sharedPreferences.getString("question13hindi", "");
        String question14Result = sharedPreferences.getString("question14hindi", "");
        String question15Result = sharedPreferences.getString("question15hindi", "");
        String question16Result = sharedPreferences.getString("question16hindi", "");
        String question17Result = sharedPreferences.getString("question17hindi", "");
        String question18Result = sharedPreferences.getString("question18hindi", "");
        String question19Result = sharedPreferences.getString("question19hindi", "");
        String question20Result = sharedPreferences.getString("question20hindi", "");
        String question21Result = sharedPreferences.getString("question21hindi", "");

        if (question1Result.equals("हमेशा")) {
            stress = stress + 3;

        } else if (question1Result.equals("अक्सर")) {
            stress = stress + 2;
        } else if (question1Result.equals("कभी कभी")) {
            stress = stress + 1;
        }
        if (question2Result.equals("हमेशा")) {
            stress = stress + 3;
        } else if (question2Result.equals("अक्सर")) {
            stress = stress + 2;
        } else if (question2Result.equals("कभी कभी")) {
            stress = stress + 1;
        }
        if (question3Result.equals("हमेशा")) {
            anxiety = anxiety + 3;
        } else if (question3Result.equals("अक्सर")) {
            anxiety = anxiety + 2;
        } else if (question3Result.equals("कभी कभी")) {
            anxiety = anxiety + 1;
        }
        if (question4Result.equals("हमेशा")) {
            depression = depression + 3;
        } else if (question4Result.equals("अक्सर")) {
            depression = depression + 2;
        } else if (question4Result.equals("कभी कभी")) {
            depression = depression + 1;
        }
        if (question5Result.equals("हमेशा")) {
            anxiety = anxiety + 3;
        } else if (question5Result.equals("अक्सर")) {
            anxiety = anxiety + 2;
        } else if (question5Result.equals("कभी कभी")) {
            anxiety = anxiety + 1;
        }
        if (question6Result.equals("हमेशा")) {
            depression = depression + 3;
        } else if (question6Result.equals("अक्सर")) {
            depression = depression + 2;
        } else if (question6Result.equals("कभी कभी")) {
            depression = depression + 1;
        }
        if (question7Result.equals("हमेशा")) {
            anxiety = anxiety + 3;
        } else if (question7Result.equals("अक्सर")) {
            anxiety = anxiety + 2;
        } else if (question7Result.equals("कभी कभी")) {
            anxiety = anxiety + 1;
        }
        if (question8Result.equals("हमेशा")) {
            stress = stress + 3;
        } else if (question8Result.equals("अक्सर")) {
            stress = stress + 2;
        } else if (question8Result.equals("कभी कभी")) {
            stress = stress + 1;
        }
        if (question9Result.equals("हमेशा")) {
            anxiety = anxiety + 3;
        } else if (question9Result.equals("अक्सर")) {
            anxiety = anxiety + 2;
        } else if (question9Result.equals("कभी कभी")) {
            anxiety = anxiety + 1;
        }
        if (question10Result.equals("हमेशा")) {
            depression = depression + 3;
        } else if (question10Result.equals("अक्सर")) {
            depression = depression + 2;
        } else if (question10Result.equals("कभी कभी")) {
            depression = depression + 1;
        }
        if (question11Result.equals("हमेशा")) {
            stress = stress + 3;
        } else if (question11Result.equals("अक्सर")) {
            stress = stress + 2;
        } else if (question11Result.equals("कभी कभी")) {
            stress = stress + 1;
        }
        if (question12Result.equals("हमेशा")) {
            stress = stress + 3;
        } else if (question12Result.equals("अक्सर")) {
            stress = stress + 2;
        } else if (question12Result.equals("कभी कभी")) {
            stress = stress + 1;
        }
        if (question13Result.equals("हमेशा")) {
            depression = depression + 3;
        } else if (question13Result.equals("अक्सर")) {
            depression = depression + 2;
        } else if (question13Result.equals("कभी कभी")) {
            depression = depression + 1;
        }
        if (question14Result.equals("हमेशा")) {
            stress = stress + 3;
        } else if (question14Result.equals("अक्सर")) {
            stress = stress + 2;
        } else if (question14Result.equals("कभी कभी")) {
            stress = stress + 1;
        }
        if (question15Result.equals("हमेशा")) {
            anxiety = anxiety + 3;
        } else if (question15Result.equals("अक्सर")) {
            anxiety = anxiety + 2;
        } else if (question15Result.equals("कभी कभी")) {
            anxiety = anxiety + 1;
        }
        if (question16Result.equals("हमेशा")) {
            depression = depression + 3;
        } else if (question16Result.equals("अक्सर")) {
            depression = depression + 2;
        } else if (question16Result.equals("कभी कभी")) {
            depression = depression + 1;
        }
        if (question17Result.equals("हमेशा")) {
            depression = depression + 3;
        } else if (question17Result.equals("अक्सर")) {
            depression = depression + 2;
        } else if (question17Result.equals("कभी कभी")) {
            depression = depression + 1;
        }
        if (question18Result.equals("हमेशा")) {
            stress = stress + 3;
        } else if (question18Result.equals("अक्सर")) {
            stress = stress + 2;
        } else if (question18Result.equals("कभी कभी")) {
            stress = stress + 1;
        }
        if (question19Result.equals("हमेशा")) {
            anxiety = anxiety + 3;
        } else if (question19Result.equals("अक्सर")) {
            anxiety = anxiety + 2;
        } else if (question19Result.equals("कभी कभी")) {
            anxiety = anxiety + 1;
        }
        if (question20Result.equals("हमेशा")) {
            anxiety = anxiety + 3;
        } else if (question20Result.equals("अक्सर")) {
            anxiety = anxiety + 2;
        } else if (question20Result.equals("कभी कभी")) {
            anxiety = anxiety + 1;
        }
        if (question21Result.equals("हमेशा")) {
            depression = depression + 3;
        } else if (question21Result.equals("अक्सर")) {
            depression = depression + 2;
        } else if (question21Result.equals("कभी कभी")) {
            depression = depression + 1;
        }


        if (anxiety >= 0 && anxiety <= 7) {
            anedit.setText("ANXIETY - NORMAL");
        } else if (anxiety >= 8 && anxiety <= 9) {
            anedit.setText("ANXIETY - MILD");
        } else if (anxiety >= 10 && anxiety <= 14) {
            anedit.setText("ANXIETY - MODERATE");
        } else if (anxiety >= 15 && anxiety <= 19) {
            anedit.setText("ANXIETY - SEVERE");
        } else if (anxiety >= 20) {
            anedit.setText("ANXIETY - EXTREMELY SEVERE");
        }


        if (stress >= 0 && stress <= 14) {
            stressedit.setText("STRESS - NORMAL");
        } else if (stress >= 15 && stress <= 18) {
            stressedit.setText("STRESS - MILD");
        } else if (stress >= 19 && stress <= 25) {
            stressedit.setText("STRESS - MODERATE");
        } else if (stress >= 26 && stress <= 33) {
            stressedit.setText("STRESS - SEVERE");
        } else if (stress >= 34) {
            stressedit.setText("STRESS - EXTREMELY SEVERE");
        }


        if (depression >= 0 && depression <= 9) {
            deedit.setText("DEPRESSION - NORMAL");
        } else if (depression >= 10 && depression <= 13) {
            deedit.setText("DEPRESSION - MILD");
        } else if (depression >= 14 && depression <= 20) {
            deedit.setText("DEPRESSION - MODERATE");
        } else if (depression >= 21 && depression <= 27) {
            deedit.setText("DEPRESSION - SEVERE");
        } else if (depression >= 28) {
            deedit.setText("DEPRESSION - EXTREMELY SEVERE");
        }

        if (depression >= 14) {
            Test.setVisibility(View.VISIBLE);
            Test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (depression >= 14) {
                        Intent k = new Intent(ResultHindi.this, Test_ques1.class);
                        startActivity(k);
                    }
                }
            });
        } else {
            Remedy.setVisibility(View.VISIBLE);
        }

        //further test for anxiety if depression in also high

        if (anxiety >= 15) {
            Test2.setVisibility(View.VISIBLE);
            Test2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    {
                        Intent k = new Intent(ResultHindi.this, Gad_ques1.class);
                        startActivity(k);
                    }
                }
            });
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // This will finish the current activity and remove it from the back stack
    }

}