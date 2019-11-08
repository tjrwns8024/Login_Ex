package com.example.login.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.login.Api.ApiInterface;
import com.example.login.Api.Retrofit;
import com.example.login.Entity.JsonParse;
import com.example.login.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView name;
    public SharedPreferences mPreferneces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferneces = getSharedPreferences("com.example.login.Activity",MODE_PRIVATE);

        name = findViewById(R.id.name);

          nameSet();
    }
    public void nameSet(){
        Retrofit retrofit = new Retrofit();
        ApiInterface apiInterface = retrofit.apiInterface;

        String jwt =mPreferneces.getString("token","");

        Call<JsonParse> main =apiInterface.jwtPost(jwt);
        main.enqueue(new Callback<JsonParse>() {
            @Override
            public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                name.setText(response.body().getName());
            }

            @Override
            public void onFailure(Call<JsonParse> call, Throwable t) {

            }
        });



    }


}


