package com.samansepahvand.chatmessagehandler.client;

import android.text.PrecomputedText;
import android.util.Log;
import android.widget.Toast;

import com.samansepahvand.chatmessagehandler.model.ChatModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {


    @GET("Photos")
    Call  <List<ChatModel>> getPhoto();


}
