package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdditionalDetails extends AppCompatActivity{
    EditText height,weight,bloodgrp,gender;
    Button conbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_details);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bloodgrp = findViewById(R.id.bloodgrp);
        gender = findViewById(R.id.gender);
        conbtn = findViewById(R.id.con);

        conbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightnum = height.getText().toString();
                String weightnum = weight.getText().toString();
                String blood = bloodgrp.getText().toString();
                String gen = gender.getText().toString();
                //function to check validation
                Boolean check = validateinfo(heightnum,weightnum,blood,gen);
                if(check == false)
                {
                    Toast.makeText(AdditionalDetails.this, "INFORMATION IS INVALID", Toast.LENGTH_SHORT).show();
                }
                if(check==true)
                {
                            Intent v = new Intent(AdditionalDetails.this,login.class);
                            startActivity(v);
                }
            }
            private Boolean validateinfo(String heightnum, String weightnum,String blood, String gen) {
                if (heightnum.length() == 0) {
                    height.requestFocus();
                    height.setError("FIELD CANNOT BE EMPTY");
                    return (false);
                }
                else if (weightnum.length() == 0) {
                    weight.requestFocus();
                    weight.setError("FIELD CANNOT BE EMPTY");
                    return (false);
                } else if (blood.length() == 0) {
                    bloodgrp.requestFocus();
                    bloodgrp.setError("FIELD CANNOT BE EMPTY");
                    return (false);
                } else if (gen.length() == 0) {
                    gender.requestFocus();
                    gender.setError("FIELD CANNOT BE EMPTY");
                    return (false);
                } else {
                    return (true);
                }
            }
        });

    }


}