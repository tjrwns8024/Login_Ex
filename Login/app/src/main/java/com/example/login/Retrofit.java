package com.example.login;

import com.google.gson.Gson;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private String BASE_URL = "https://192.168.137.108:8080/";
    retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiInterface apiInterface = retrofit.create(ApiInterface.class);
}
