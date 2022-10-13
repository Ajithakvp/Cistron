package com.example.cistron.InterFace;

import com.example.cistron.DataParse.responsemodel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AttendanceInterface {

    //db_insert2.php?action=serv_attend&place=1&area=Trichy

    @FormUrlEncoded
    @POST("db_insert2.php")
    Call<responsemodel> getAttendance(@Field("place") String place, @Field("area") String area);
}
