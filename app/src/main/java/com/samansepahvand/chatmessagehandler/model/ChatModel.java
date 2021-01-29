package com.samansepahvand.chatmessagehandler.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatModel  {




    @SerializedName("albumId")
    @Expose
    private  int albumId;
    @SerializedName("id")
    @Expose
    private  int id;
    @SerializedName("title")
    @Expose
    private  String title;

    @SerializedName("url")
    @Expose
    private  String url;


    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
