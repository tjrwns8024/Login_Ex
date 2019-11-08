package com.example.login.Api;

import com.example.login.Entity.JsonParse;
import com.example.login.Entity.Res;
import com.example.login.Entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("user/login/")
    Call<JsonParse> signinPost(@Body User user);

    @POST("user/signup/")
    Call<JsonParse> signupPost(@Body Res res);

    @GET("user/")
    Call<JsonParse> jwtPost(@Header("Authorization") String jwt);
}
