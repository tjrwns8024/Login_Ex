package com.example.login;

import com.google.gson.annotations.SerializedName;

public class JsonParse {
    @SerializedName("userId")
    private String userId;

    @SerializedName("userPw")
    private String userPw;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
}
