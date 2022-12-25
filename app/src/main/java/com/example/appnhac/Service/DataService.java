package com.example.appnhac.Service;

import com.example.appnhac.Model.Playlist;
import com.example.appnhac.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("randomplaylisteveryday.php")
    Call<List<Playlist>> GetPlaylistEveryDay();


}
