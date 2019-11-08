package com.example.login.Entity;

import com.google.gson.annotations.SerializedName;

public class Res {
    @SerializedName("userId")
    String resId;
    @SerializedName("userPw")
    String resPw;
    @SerializedName("userName")
    String resName;

    public Res(String resId, String resPw, String resName)
    {
        this.resId = resId;
        this.resPw = resPw;
        this.resName = resName;
    }
}
