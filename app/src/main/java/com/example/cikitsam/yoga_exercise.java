package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yoga_exercise extends AppCompatActivity {

    CardView yp1,yp2,yp3,yp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_exercise);
        yp1 = findViewById(R.id.Kapalbhati);
        yp2 = findViewById(R.id.Simhasana);
        yp3 = findViewById(R.id.Makarasana);
        yp4 = findViewById(R.id.Butterfly);
        yp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(yoga_exercise.this,Kapalbhati.class);
                startActivity(l);
            }
        });
        yp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(yoga_exercise.this,Simhasana.class);
                startActivity(l);
            }
        });
        yp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(yoga_exercise.this,Makarasana.class);
                startActivity(l);
            }
        });
        yp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCardViewClicked();
            }

            private void onCardViewClicked() {
                Intent l = new Intent(yoga_exercise.this,Butterfly.class);
                startActivity(l);
            }
        });

    }
}