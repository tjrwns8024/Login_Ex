package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signin extends AppCompatActivity {

    TextView go_signup;
    TextInputEditText signin_id;
    TextInputLayout signin_edit_id_area;
    Button signin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signin_btn = findViewById(R.id.signin_btn);
        go_signup = findViewById(R.id.go_signup);
        signin_id = findViewById(R.id.signin_id);
        signin_edit_id_area = findViewById(R.id.signin_edit_id_area);

        signin_edit_id_area.setErrorEnabled(true);

        go_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, Signup.class);
                startActivity(intent);
            }
        });

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin_email_check(signin_id.getText().toString());
            }
        });

    }
    public void signin_email_check(String signin_id){
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(signin_id).matches()){
            signin_edit_id_area.setError("");
        }
        else {
            signin_edit_id_area.setError("이메일 형식에 맞게 입력해주세요");
        }
    }
}
