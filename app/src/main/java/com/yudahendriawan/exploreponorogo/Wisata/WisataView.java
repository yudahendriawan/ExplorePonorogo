package com.yudahendriawan.exploreponorogo.Wisata;

import com.yudahendriawan.exploreponorogo.Model.Wisata;

import java.util.List;

public interface WisataView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Wisata> wisata);
    void onErrorLoading(String message);
}
