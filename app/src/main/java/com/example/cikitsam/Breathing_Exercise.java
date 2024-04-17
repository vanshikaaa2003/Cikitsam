package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Breathing_Exercise extends AppCompatActivity {

    CardView breathholdtest,equalbreath,breathing478,boxbreathing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);
        breathholdtest = findViewById(R.id.hold_test);
        equalbreath = findViewById(R.id.equal_breathing);
        breathing478 = findViewById(R.id.breathing_4_7_8);
        boxbreathing = findViewById(R.id.box_breathing);

        breathholdtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(Breathing_Exercise.this,Breath_holdTest.class);
                startActivity(l);
            }
        });
        equalbreath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(Breathing_Exercise.this,Equal_Breathing.class);
                startActivity(l);
            }

        });
        breathing478.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(Breathing_Exercise.this,Breathing_478.class);
                startActivity(l);
            }
        });
        boxbreathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(Breathing_Exercise.this,Box_Breathing.class);
                startActivity(l);
            }
        });
    }
}