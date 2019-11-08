package com.example.login.Api;

import com.example.login.Api.ApiInterface;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private String BASE_URL = "https://jinhong0719.pythonanywhere.com";

    retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public ApiInterface apiInterface = retrofit.create(ApiInterface.class);
}
