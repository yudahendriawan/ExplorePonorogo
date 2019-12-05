package com.yudahendriawan.exploreponorogo.coffee;

import com.yudahendriawan.exploreponorogo.model.Coffee;
import com.yudahendriawan.exploreponorogo.model.Wisata;

import java.util.List;

public interface CoffeeView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Coffee> coffee);
    void onErrorLoading(String message);
}
