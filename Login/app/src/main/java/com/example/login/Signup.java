package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    TextInputLayout signup_edit_password_ck_area;
    TextInputLayout signup_edit_code_area;
    TextInputLayout signup_edit_id_area;
    TextInputLayout signup_edit_user_area;
    TextInputEditText signup_code;
    TextInputEditText signup_id;
    TextInputEditText signup_password;
    TextInputEditText signup_password_ck;
    TextInputEditText signup_user;
    Button complete_signup;
    String a = "030916";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup_code = findViewById(R.id.signup_code);
        signup_edit_code_area = findViewById(R.id.signup_edit_code_area);
        signup_edit_user_area = findViewById(R.id.signup_edit_user_area);
        signup_edit_password_ck_area = findViewById(R.id.signup_edit_password_ck_area);
        signup_edit_id_area = findViewById(R.id.signup_edit_id_area);
        signup_id = findViewById(R.id.signup_id);
        signup_password = findViewById(R.id.signup_password);
        signup_password_ck = findViewById(R.id.signup_password_ck);
        complete_signup = findViewById(R.id.complete_signup);
        signup_user = findViewById(R.id.signup_user);

        signup_edit_id_area.setErrorEnabled(true);
        signup_edit_password_ck_area.setEnabled(true);
        signup_edit_user_area.setErrorEnabled(true);
        signup_edit_code_area.setErrorEnabled(true);

       complete_signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               emailError(signup_id.getText().toString());
               passwordCheck(signup_password.getText().toString(), signup_password_ck.getText().toString());
               userName(signup_user.getText().toString());
               Verification(signup_code.getText().toString());
           }
       });
    }
    public void emailError(String signup_id){
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(signup_id).matches()){
            signup_edit_id_area.setError("");
        }
        else
            signup_edit_id_area.setError("이메일 형식대로 입력해주세요");
    }
    public void passwordCheck(String signup_password, String signup_password_ck){
        if(signup_password .equals(signup_password_ck)) {
            signup_edit_password_ck_area.setError("");
        }
        else
            signup_edit_password_ck_area.setError("비밀번호가 일치하지 않아요");
        }
    public void userName(String signup_user){
        if(signup_user.length()>3 && signup_user.length()<=12){
            signup_edit_user_area.setError("");
        }
        else
            signup_edit_user_area.setError("4~12글자 이내로 입력해주세요");
    }
    public void Verification(String signup_code){
        if(signup_code.equals(a)){
            signup_edit_code_area.setError("");
        }
        else
            signup_edit_code_area.setError("인증번호가 일치 하지 않아요");
    }
}