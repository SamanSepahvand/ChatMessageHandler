package com.samansepahvand.chatmessagehandler;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.samansepahvand.chatmessagehandler.adpter.MyAdapter;
import com.samansepahvand.chatmessagehandler.client.ApiClient;
import com.samansepahvand.chatmessagehandler.client.ApiInterface;
import com.samansepahvand.chatmessagehandler.model.ChatModel;
import com.samansepahvand.chatmessagehandler.util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main extends AppCompatActivity {


    private  static final String TAG="tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        intiView();



    }



    private void intiView(){
    }




}