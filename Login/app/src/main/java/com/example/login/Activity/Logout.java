package com.example.login.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.login.Api.ApiInterface;
import com.example.login.Api.Retrofit;
import com.example.login.Entity.JsonParse;
import com.example.login.R;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Logout extends AppCompatActivity {

    Button logout;
    private SharedPreferences mPreferences;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        mPreferences = getSharedPreferences("com.example.login.Activity", MODE_PRIVATE);

        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);

        nameSet();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLogout();
            }
        });
    }

    public void setLogout() {


        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();

        Intent intent = new Intent(Logout.this, MainActivity.class);
        startActivity(intent);
    }

    public void nameSet() {
        Retrofit retrofit = new Retrofit();
        ApiInterface apiInterface = retrofit.apiInterface;

        String jwt = mPreferences.getString("token", "none");

        Call<JsonParse> main = apiInterface.jwtPost(jwt);
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
