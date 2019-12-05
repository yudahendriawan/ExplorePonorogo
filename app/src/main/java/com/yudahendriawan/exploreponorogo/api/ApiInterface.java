package com.yudahendriawan.exploreponorogo.api;

import com.yudahendriawan.exploreponorogo.model.Coffee;
import com.yudahendriawan.exploreponorogo.model.Food;
import com.yudahendriawan.exploreponorogo.model.Wisata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("wisata.php")
    Call<List<Wisata>> getWisata();

    @GET("coffee.php")
    Call<List<Coffee>> getCoffee();

    @GET("food.php")
    Call<List<Food>> getFood();
}
