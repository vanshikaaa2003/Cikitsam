package com.example.cikitsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Button signup;
    EditText nameEtv , usernameEtv,numberEtv, emailEtv , passwordEtv,AgeEtv;
   // FirebaseDatabase database;
    //DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup = findViewById(R.id.signin);
        usernameEtv = findViewById(R.id.uname);
        nameEtv = findViewById(R.id.name);
        numberEtv = findViewById(R.id.num);
        emailEtv = findViewById(R.id.email);
        passwordEtv = findViewById(R.id.pws);
        AgeEtv = findViewById(R.id.age);
       /* String username = usernameEtv.getText().toString();
        String name = nameEtv.getText().toString();
        String number = numberEtv.getText().toString();
        String email = emailEtv.getText().toString();
        String password = passwordEtv.getText().toString();
        String age = AgeEtv.getText().toString();*/




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //database connectivity
                //database = FirebaseDatabase.getInstance();
                //reference = database.getReference("users");

                String username = usernameEtv.getText().toString();
                String name = nameEtv.getText().toString();
                String number = numberEtv.getText().toString();
                String email = emailEtv.getText().toString();
                String password = passwordEtv.getText().toString();
                String age = AgeEtv.getText().toString();

                HelperClass helperClass = new HelperClass(name,username,email,age,number,password);
               // reference.child(name).setValue(helperClass);

                Toast.makeText(SignUp.this, "You have signed up successfully", Toast.LENGTH_SHORT).show();
                //function to check validation
                Boolean check = validateinfo(name,number,password,email);
                if(check == false)
                {
                    Toast.makeText(SignUp.this, "INFORMATION IS INVALID", Toast.LENGTH_SHORT).show();
                }
                if(check==true)
                {
                    signup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent s = new Intent(SignUp.this,AdditionalDetails.class);
                            startActivity(s);
                        }
                    });


                }
            }
            private Boolean validateinfo(String name, String number,String password, String email) {
                if(name.length()==0)
                {
                    nameEtv.requestFocus();
                    nameEtv.setError("Field cannot be empty");
                    return(false);
                }
                else if(!name.matches("[a-zA-Z]+"))
                {
                    nameEtv.requestFocus();
                    nameEtv.setError("Enter only alphabetical character");
                    return(false);
                }
                else if (number.length()==0)
                {
                    numberEtv.requestFocus();
                    numberEtv.setError("FIELD CANNOT BE EMPTY");
                    return(false);
                }
                else if(number.length()!=10)
                {
                    numberEtv.requestFocus();
                    numberEtv.setError("Enter the valid Number");
                    return(false);
                }
                else if (email.length()==0)
                {
                    emailEtv.requestFocus();
                    emailEtv.setError("FIELD CANNOT BE EMPTY");
                    return(false);
                }
                else if(!email.matches("[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+"))
                {
                    emailEtv.requestFocus();
                    emailEtv.setError("Enter valid email");
                    return(false);
                }
                else if(password.length()<=5)
                {
                    passwordEtv.requestFocus();
                    passwordEtv.setError("MINIMUM 6 CHARACTERS REQUIRED");
                    return(false);
                }
                else
                {
                    return(true);
                }
            }
        });
    }
}