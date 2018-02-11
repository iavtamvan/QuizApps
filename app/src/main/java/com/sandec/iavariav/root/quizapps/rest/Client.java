package com.sandec.iavariav.root.quizapps.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by idn on 8/12/2017.
 */

public class Client {

//    private static String BASE_URL = "http://158.69.130.8:92/api/";
//    private static String BASE_URL = "http://103.82.242.158:803/api/";
    private static String BASE_URL = "http://192.168.43.57/local/Udinus/";
//    private static String BASE_URL = "http://suci.can.web.id/ins/";
    private static Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
    public static ApiService getInstanceRetrofit(){
        return getClient().create(ApiService.class);
    }
}
