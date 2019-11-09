package com.example.login.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    Button goto_login;
    public SharedPreferences mPreferneces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        goto_login = findViewById(R.id.goto_login);
//        mPreferneces = getSharedPreferences("com.example.login.Activity",MODE_PRIVATE);
        main.setText("사용자 없음");

        goto_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signin.class);
                startActivity(intent);
            }
        });

    }
    public void current_name(){
//        Retrofit retrofit = new Retrofit();
//        ApiInterface apiInterface = retrofit.apiInterface;
//
//        String current_jwt = mPreferneces.getString("token","");
//
//        Call<JsonParse> current = apiInterface.jwtPost(current_jwt);
//        current.enqueue(new Callback<JsonParse>() {
//            @Override
//            public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
//                if(response.isSuccessful())
//                    main.setText("none");
//                Log.d("logut_error",response.code()+"");
//                Log.d("current_token",);
//            }
//
//            @Override
//            public void onFailure(Call<JsonParse> call, Throwable t) {
//                Log.e("current_user_error","다시 ㄱ");
//                Log.d("code_확인",""+t.getMessage());
//            }
//        });
    }
}