package com.example.login.Entity;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userId")
    String userId;
    @SerializedName("userPw")
    String userPw;

    public User(String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
    }
}
