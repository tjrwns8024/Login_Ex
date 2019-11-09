package com.example.login.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.login.Api.ApiInterface;
import com.example.login.Api.Retrofit;
import com.example.login.Entity.JsonParse;
import com.example.login.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView main;
    public SharedPreferences mPreferneces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferneces = getSharedPreferences("com.example.login.Activity",MODE_PRIVATE);

        current_name();

    }
    public void current_name(){
        Retrofit retrofit = new Retrofit();
        ApiInterface apiInterface = retrofit.apiInterface;

        String current_jwt = mPreferneces.getString("token","");

        Call<JsonParse> current = apiInterface.jwtPost(current_jwt);
        current.enqueue(new Callback<JsonParse>() {
            @Override
            public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                main.setText("로그아웃 됨");
            }

            @Override
            public void onFailure(Call<JsonParse> call, Throwable t) {
                Log.e("current_user_error","다시 ㄱ");
                Log.d("code_확인",""+t.getMessage());
            }
        });
    }
}