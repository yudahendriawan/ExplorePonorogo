package com.yudahendriawan.exploreponorogo.coffee;

import androidx.annotation.NonNull;

import com.yudahendriawan.exploreponorogo.api.ApiClient;
import com.yudahendriawan.exploreponorogo.api.ApiInterface;
import com.yudahendriawan.exploreponorogo.model.Coffee;
import com.yudahendriawan.exploreponorogo.model.Wisata;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoffeePresenter {

    private CoffeeView view;

    public CoffeePresenter(CoffeeView view) {
        this.view = view;
    }

    void getData(){
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Coffee>> call = apiInterface.getCoffee();

        call.enqueue(new Callback<List<Coffee>>() {
            @Override
            public void onResponse(@NonNull Call<List<Coffee>> call, @NonNull Response<List<Coffee>> response) {
                view.hideLoading();

                if(response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Coffee>> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
