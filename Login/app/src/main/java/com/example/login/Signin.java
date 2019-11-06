package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.login.databinding.ActivitySigninBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signin extends AppCompatActivity {

   ActivitySigninBinding signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signin = DataBindingUtil.setContentView(this,R.layout.activity_signin);

        signin.signinEditIdArea.setErrorEnabled(true);

        signin.goSignup.setOnClickListener(new View.OnClickListener() {
            @Override   
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, Signup.class);
                startActivity(intent);
            }
        });

        signin.signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin_email_check(signin.signinId.getText().toString());
            }
        });

    }
    public void signin_email_check(String signin_id){
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(signin_id).matches()){
            signin.signinEditIdArea.setError("");
        }
        else {
            signin.signinEditIdArea.setError("이메일 형식에 맞게 입력해주세요");
        }
    }
}
