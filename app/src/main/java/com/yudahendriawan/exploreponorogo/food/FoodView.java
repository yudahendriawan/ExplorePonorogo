package com.yudahendriawan.exploreponorogo.food;

import com.yudahendriawan.exploreponorogo.model.Food;

import java.util.List;

public interface FoodView {
    void showLoading();

    void hideLoading();

    void onGetResult(List<Food> food);

    void onErrorLoading(String message);
}
