package com.yudahendriawan.exploreponorogo.Wisata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yudahendriawan.exploreponorogo.Model.Wisata;
import com.yudahendriawan.exploreponorogo.R;

import java.util.List;

public class WisataActivity extends AppCompatActivity implements WisataView {

    private static final int INTENT_EDIT = 200;
    private static final int INTENT_ADD = 100;

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;

    WisataPresenter presenter;
    WisataAdapter adapter;
    WisataAdapter.ItemClickListener itemClickListener;
    List<Wisata> wisatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        recyclerView = findViewById(R.id.recyclerview);
        swipeRefresh = findViewById(R.id.swipe_refresh);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new WisataPresenter(this);
        presenter.getData();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
            }
        });

        itemClickListener = (new WisataAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int id = wisatas.get(position).getId();

            }
        });


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//
//        if (requestCode == INTENT_ADD && resultCode == RESULT_OK) {
//            presenter.getData(); //reload data
//        } else if (requestCode == INTENT_EDIT && resultCode == RESULT_OK) {
//            presenter.getData();
//        }
//    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);

    }

    @Override
    public void hideLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<Wisata> wisata) {
        adapter = new WisataAdapter(this, wisata, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        wisata = wisatas;
    }

    @Override
    public void onErrorLoading(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
