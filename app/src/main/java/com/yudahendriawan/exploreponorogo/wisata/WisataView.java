package com.yudahendriawan.exploreponorogo.wisata;

import com.yudahendriawan.exploreponorogo.model.Wisata;

import java.util.List;

public interface WisataView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Wisata> wisata);
    void onErrorLoading(String message);
}
