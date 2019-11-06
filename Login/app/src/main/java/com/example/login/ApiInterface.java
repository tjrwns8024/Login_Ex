package com.example.login;

import retrofit2.Call;
import retrofit2.http.Body;
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
    Call<JsonParse> signupPost(@Field("res_Id")String res_Id,
                               @Field("res_pw") String res_pw,
                               @Field("res_pw_ck")String res_pw_ck,
                               @Field("res_name")String res_name);

}
