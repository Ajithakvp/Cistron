package com.example.cistron.DataParse;

import com.example.cistron.InterFace.LoginInterFace;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

   //private static final String LOGINURL = "http://192.168.29.173/beta1/app/";
  private static final String LOGINURL = "https://cistronsystems.in/beta1/";
    private static ApiClient clientobject;
    private static Retrofit retrofit;

  public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(LOGINURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;

    }
}

//    ApiClient() {
//         retrofit = new Retrofit.Builder()
//                .baseUrl(LOGINURL)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//    }
//
//    public static synchronized ApiClient getInstance() {
//        if (clientobject == null)
//            clientobject = new ApiClient();
//            return clientobject;
//
//
//    }
//    public LoginInterFace getApi()
//    {
//        return retrofit.create(LoginInterFace.class);
//    }
//    }






//    private static Retrofit retrofit = null;
//
//    static Retrofit getClient() {
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
//
//
//        retrofit = new Retrofit.Builder()
//                .baseUrl("")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build();
//
//
//
//        return retrofit;
//    }