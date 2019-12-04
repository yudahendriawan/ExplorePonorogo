package com.yudahendriawan.exploreponorogo.Wisata;

import androidx.annotation.NonNull;

import com.yudahendriawan.exploreponorogo.Model.Wisata;
import com.yudahendriawan.exploreponorogo.RestApi.ApiClient;
import com.yudahendriawan.exploreponorogo.RestApi.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataPresenter {

    private WisataView view;

    public WisataPresenter(WisataView view) {
        this.view = view;
    }

    void getData(){
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Wisata>> call = apiInterface.getWisata();

        call.enqueue(new Callback<List<Wisata>>() {
            @Override
            public void onResponse(@NonNull Call<List<Wisata>> call,@NonNull Response<List<Wisata>> response) {
                view.hideLoading();

                if(response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Wisata>> call,@NonNull Throwable t) {
                    view.hideLoading();
                    view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
