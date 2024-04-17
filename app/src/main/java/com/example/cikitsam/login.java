package com.example.cikitsam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login extends AppCompatActivity {
    EditText loginusername,loginpw;
    TextView forgotpw , signup;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotpw = findViewById(R.id.forgotpw);
        signup = findViewById(R.id.signupacc);
        login =  findViewById(R.id.login);
        loginusername = findViewById(R.id.uname);
        loginpw = findViewById(R.id.pws);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /* if(!validatepassword() || !validateusername())
                {
                }
                else
                {
                    checkuser();
                }*/
           Intent on = new Intent(login.this,MainActivity.class);
            startActivity(on);
            }
        });
    }
    public void onClicksignup(View v)
    {
        Intent k = new Intent(login.this,SignUp.class);
        startActivity(k);
    }
  /*  public boolean validateusername()
    {
        String username = loginusername.getText().toString();
        if(username.isEmpty())
        {
            loginusername.setError("username cannot be empty");
            return false;
        }
        else
        {
            loginusername.setError(null);
            return true;
        }
    }
    public boolean validatepassword()
    {
        String password = loginpw.getText().toString();
        if(password.isEmpty())
        {
            loginpw.setError("username cannot be empty");
            return false;
        }
        else
        {
            loginpw.setError(null);
            return true;
        }
    }
    public void checkuser()
    {
        String userusername = loginusername.getText().toString().trim();
        String userpassword = loginpw.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkuserdatabase = reference.orderByChild("username").equalTo(userusername);

        checkuserdatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    loginusername.setError(null);
                    String passwordfromDB = snapshot.child(userusername).child("password").getValue(String.class);

                    if (Objects.equals(passwordfromDB, userpassword)) {
                        loginusername.setError(null);
                        Intent on = new Intent(login.this, MainActivity.class);
                        startActivity(on);
                    } else {
                        loginpw.setError("Invalid Credentials");
                        loginpw.requestFocus();
                    }
                }
                else
                {
                    loginusername.setError("User does not exist");
                    loginusername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/
}
