package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class Setting extends AppCompatActivity {
    CardView terms;
    Dialog dailog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

         terms= findViewById(R.id.terms);
         terms.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent n = new Intent(Setting.this,Terms_Conditions.class);
                 startActivity(n);
             }
         });
    }
}