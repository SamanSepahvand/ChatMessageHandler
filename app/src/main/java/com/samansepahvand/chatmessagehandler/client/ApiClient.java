package com.samansepahvand.chatmessagehandler.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saman on 25/08/20.
 */

public class ApiClient {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
