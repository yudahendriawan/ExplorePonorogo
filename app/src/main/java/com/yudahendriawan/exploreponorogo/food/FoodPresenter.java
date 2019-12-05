package com.yudahendriawan.exploreponorogo.food;

import androidx.annotation.NonNull;

import com.yudahendriawan.exploreponorogo.api.ApiClient;
import com.yudahendriawan.exploreponorogo.api.ApiInterface;
import com.yudahendriawan.exploreponorogo.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodPresenter {

    FoodView view;

    public FoodPresenter(FoodView view) {
        this.view = view;
    }

    void getData() {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Food>> call = apiInterface.getFood();

        call.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(@NonNull Call<List<Food>> call, @NonNull Response<List<Food>> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Food>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
