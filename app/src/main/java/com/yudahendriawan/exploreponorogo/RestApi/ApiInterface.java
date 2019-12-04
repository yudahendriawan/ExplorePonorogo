package com.yudahendriawan.exploreponorogo.RestApi;

import com.yudahendriawan.exploreponorogo.Model.Wisata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("wisata.php")
    Call<List<Wisata>> getWisata();
}
