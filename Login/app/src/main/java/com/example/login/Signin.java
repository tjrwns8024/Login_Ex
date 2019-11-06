package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.login.databinding.ActivitySigninBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signin extends AppCompatActivity {

    ActivitySigninBinding signin_bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signin_bind = DataBindingUtil.setContentView(this, R.layout.activity_signin);

        signin_bind.signinEditIdArea.setErrorEnabled(true);

        signin_bind.goSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, Signup.class);
                startActivity(intent);
            }
        });

        signin_bind.signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin_email_check(signin_bind.signinId.getText().toString());
            }
        });
        signin_post();
    }

    public void signin_email_check(String signin_id) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(signin_id).matches()) {
            signin_bind.signinEditIdArea.setError("");
        } else {
            signin_bind.signinEditIdArea.setError("이메일 형식에 맞게 입력해주세요");
        }
    }

    public void signin_post() {
        Retrofit retrofit = new Retrofit();

        ApiInterface apiInterface = retrofit.apiInterface;
        String id;
        String pw;
        id = signin_bind.signinId.getText().toString();
        pw = signin_bind.signinPassword.getText().toString();
        User user = new User(id, pw);

        Call<JsonParse> call = apiInterface.getPost(user);
        call.enqueue(new Callback<JsonParse>() {
            @Override
            public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                if(response.code() == 200){
                }
            }
            @Override
            public void onFailure(Call<JsonParse> call, Throwable t) {
                Log.e("error","onFailure"+ t.toString());
            }
        });
    }
}
