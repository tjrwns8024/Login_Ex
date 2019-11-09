package com.example.login.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.login.Api.ApiInterface;
import com.example.login.Entity.JsonParse;
import com.example.login.R;
import com.example.login.Api.Retrofit;
import com.example.login.Entity.User;
import com.example.login.databinding.ActivitySigninBinding;

import java.util.prefs.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signin extends AppCompatActivity {

    ActivitySigninBinding signin_bind;
    String jwt;
    private SharedPreferences mPreferneces;

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

                boolean isEmailCheck = signin_email_check(signin_bind.signinId.getText().toString());

                if(isEmailCheck)
                    signin_post();
            }
        });
    }

    public boolean signin_email_check(String signin_id) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(signin_id).matches()) {
            signin_bind.signinEditIdArea.setError("");
            return true;
        } else {
            signin_bind.signinEditIdArea.setError("이메일 형식에 맞게 입력해주세요");
            return false;
        }
    }

    public void signin_post() {
        Retrofit retrofit = new Retrofit();
        ApiInterface apiInterface = retrofit.apiInterface;

        String signin_id;
        String signin_pw;

        signin_id = signin_bind.signinId.getText().toString();
        signin_pw = signin_bind.signinPassword.getText().toString();

        User user = new User(signin_id, signin_pw);

        Call<JsonParse> call = apiInterface.signinPost(user);
        call.enqueue(new Callback<JsonParse>() {
            @Override
            public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                if(response.code()/100 == 2 ){
                    Log.d("succes","complete");
                    jwt = response.body().getToken();

                    Intent intent = new Intent(Signin.this, Logout.class);
                    startActivity(intent);

                    Log.d("jwt",""+response.body().getToken());

                    mPreferneces = getSharedPreferences("com.example.login.Activity",MODE_PRIVATE);
                    SharedPreferences.Editor preferencesEditor = mPreferneces.edit();
                    preferencesEditor.putString("token",jwt);
                    preferencesEditor.apply();
                }
                else{
                    Log.e("response.code",""+response.code());
                }
            }
            @Override
            public void onFailure(Call<JsonParse> call, Throwable t) {
                Log.e("error","onFailure"+ t.toString());
            }
        });
    }
}
