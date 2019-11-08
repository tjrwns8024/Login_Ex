package com.example.login.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.login.Api.ApiInterface;
import com.example.login.Entity.JsonParse;
import com.example.login.R;
import com.example.login.Entity.Res;
import com.example.login.Api.Retrofit;
import com.example.login.databinding.ActivitySignupBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {

    ActivitySignupBinding signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signup = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        signup.signupEditIdArea.setErrorEnabled(true);
        signup.signupEditPasswordCkArea.setErrorEnabled(true);
        signup.signupEditUserArea.setErrorEnabled(true);

       signup.completeSignup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               emailError(signup.signupId.getText().toString());
               passwordCheck(signup.signupPassword.getText().toString(), signup.signupPasswordCk.getText().toString());
               userName(signup.signupUser.getText().toString());
//               if(emailError(signup.signupId.getText().toString()) == true){
//                   if(passwordCheck(signup.signupPassword.getText().toString(), signup.signupPasswordCk.getText().toString()) == true)
//                       if(userName(signup.signupUser.getText().toString())==true)
//                           signup_post();
               boolean isEmailError = emailError(signup.signupId.getText().toString());
               boolean isPasswordEqual = passwordCheck(signup.signupPassword.getText().toString(), signup.signupPasswordCk.getText().toString());
               boolean isUserNameLengthNotLong = userName(signup.signupUser.getText().toString());

               if(isEmailError && isPasswordEqual && isUserNameLengthNotLong){
                   signup_post();
               }
           }
       });
    }
    public boolean emailError(String signup_id){
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(signup_id).matches()){
            signup.signupEditIdArea.setError("");
            return true;
        }
        else {
            signup.signupEditIdArea.setError("이메일 형식에 맞게 입력해주세요");
            return false;
        }
    }

    public boolean passwordCheck(String signup_password, String signup_password_ck){
        if(signup_password .equals(signup_password_ck)) {
            signup.signupEditPasswordArea.setError("");
            return true;
        }
        else
            signup.signupEditPasswordArea.setError("비밀번호가 일치하지 않아요");
            return false;
        }

    public boolean userName(String signup_user){
        if(signup_user.length()>3 && signup_user.length()<=12){
            signup.signupEditUserArea.setError("");
            return true;
        }
        else
            signup.signupEditUserArea.setError("4~12글자 이내로 입력해주세요");
        return false;
    }

    public void signup_post(){
        Retrofit retrofit = new Retrofit();
        ApiInterface apiInterface = retrofit.apiInterface;

        String signup_id;
        String signup_pw;
        String signup_name;

        signup_id = signup.signupId.getText().toString();
        signup_pw = signup.signupPassword.getText().toString();
        signup_name = signup.signupUser.getText().toString();

        Res res = new Res(signup_id,signup_pw,signup_name);

        Call<JsonParse> call = apiInterface.signupPost(res);
        call.enqueue(new Callback<JsonParse>() {
            @Override
            public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                Log.d("code",response.toString());
                if(response.code()==201) {
                    makeToast("회원가입 성공");
                    Log.d("succes","성공");

                    Intent intent = new Intent(Signup.this, Signin.class);
                    startActivity(intent);
                }
                else if(response.code()==470)
                    makeToast("아이디 중복");
                else
                    Log.d("unknown error",response.code()+"");
            }

            @Override
            public void onFailure(Call<JsonParse> call, Throwable t) {
                Log.e("error",t.getMessage());
            }
        });


    }
    private void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}