package com.example.cistron.InterFace;

import com.example.cistron.DataParse.responsemodel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterFace {

    @FormUrlEncoded
    @POST("login_chk1.php")
    Call<responsemodel> getUserLogin(

            @Field("empid") String ID,
            @Field("pwd") String password
    );

}
