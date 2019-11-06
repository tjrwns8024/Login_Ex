package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.example.login.databinding.ActivitySignupBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    ActivitySignupBinding signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signup = DataBindingUtil.setContentView(this,R.layout.activity_signup);

        signup.signupEditIdArea.setErrorEnabled(true);
        signup.signupEditPasswordCkArea.setEnabled(true);
        signup.signupEditUserArea.setErrorEnabled(true);

       signup.completeSignup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               emailError(signup.signupId.getText().toString());
               passwordCheck(signup.signupPassword.getText().toString(), signup.signupPasswordCk.getText().toString());
               userName(signup.signupUser.getText().toString());
           }
       });
    }
    public void emailError(String signup_id){
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(signup_id).matches()){
            signup.signupEditIdArea.setError("");
        }
        else
            signup.signupEditIdArea.setError("이메일 형식에 맞게 입력해주세요");
    }
    public void passwordCheck(String signup_password, String signup_password_ck){
        if(signup_password .equals(signup_password_ck)) {
            signup.signupEditPasswordArea.setError("");
        }
        else
            signup.signupEditPasswordArea.setError("비밀번호가 일치하지 않아요");
        }
    public void userName(String signup_user){
        if(signup_user.length()>3 && signup_user.length()<=12){
            signup.signupEditUserArea.setError("");
        }
        else
            signup.signupEditUserArea.setError("4~12글자 이내로 입력해주세요");
    }

}