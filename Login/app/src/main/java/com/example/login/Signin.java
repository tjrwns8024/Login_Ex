package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Signin extends AppCompatActivity {

    TextView go_signup;
    TextInputEditText signin_id;
    TextInputEditText signin_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        go_signup = findViewById(R.id.go_signup);
        signin_id = findViewById(R.id.signin_id);
        signin_password = findViewById(R.id.signin_password);

        go_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this,Signup.class);
                startActivity(intent);
            }
        });


    }
}
