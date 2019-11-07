package com.example.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("")
    Call<JsonParse> signinPost(@Field("userId") String id,
                               @Field("userPw") String pw);

    @FormUrlEncoded
    @POST("")
    Call<JsonParse> signupPost(@Field("userId")String res_id,
                               @Field("userPw") String res_pw,
                               @Field("userName")String res_name);

}
