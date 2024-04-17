package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class language extends AppCompatActivity {

    Button english,hindi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        english = findViewById(R.id.eng);
        hindi = findViewById(R.id.hindi);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lane = new Intent(language.this,Questionaire1.class);
                startActivity(lane);
            }
        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanh = new Intent(language.this,Queshindi1.class);
                startActivity(lanh);
            }
        });
    }
}