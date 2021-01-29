package com.samansepahvand.chatmessagehandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.samansepahvand.chatmessagehandler.adpter.MyAdapter;
import com.samansepahvand.chatmessagehandler.client.ApiClient;
import com.samansepahvand.chatmessagehandler.client.ApiInterface;
import com.samansepahvand.chatmessagehandler.model.ChatModel;
import com.samansepahvand.chatmessagehandler.util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private  static final String TAG="tag";



    private RecyclerView recyclerView;

    private MyAdapter adapter;

    private List<ChatModel> models;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();
        getData();



        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Toast.makeText(MainActivity.this, "onScrollStateChanged:"+newState, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                Toast.makeText(MainActivity.this, "onScrolled", Toast.LENGTH_SHORT).show();
                if (dy>0){
                    Log.e(TAG, "onScrolled:  dy>0:"+dy );
                }else if (dy<0){
                    Log.e(TAG, "onScrolled:  dy<0:"+dy );
                }
            }
        });


    }




    private void intiView(){

        recyclerView=findViewById(R.id.recyclerview);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }


    private void getData(){

        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);


        Call <List<ChatModel>> call=apiInterface.getPhoto();

        call.enqueue(new Callback<List<ChatModel>>() {
            @Override
            public void onResponse(Call<List<ChatModel>> call, Response<List<ChatModel>> response) {


                Log.e(TAG, "onResponse: "+response.toString() );
                if (!response.isSuccessful()){

                    Log.e(TAG, "onResponse: !response.isSuccessful() " );
                    return;
                }

                if (response.isSuccessful()){
                     models=response.body();
                     adapter=new MyAdapter(getBaseContext(),models);
                     recyclerView.setAdapter(adapter);
                    Constant.limit=10;


                }
            }

            @Override
            public void onFailure(Call<List<ChatModel>> call, Throwable t) {


                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });



    }


}