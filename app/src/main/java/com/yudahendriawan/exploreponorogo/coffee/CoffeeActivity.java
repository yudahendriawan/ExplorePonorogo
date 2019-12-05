package com.yudahendriawan.exploreponorogo.coffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.yudahendriawan.exploreponorogo.R;
import com.yudahendriawan.exploreponorogo.model.Coffee;

import java.util.List;

public class CoffeeActivity extends AppCompatActivity implements CoffeeView {

    private static final int INTENT_EDIT = 200;
    private static final int INTENT_ADD = 100;

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    CoffeePresenter presenter;
    CoffeeAdapter adapter;
    CoffeeAdapter.ItemClickListener itemClickListener;
    List<Coffee> coffeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

       // getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerview);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new CoffeePresenter(this);
        presenter.getData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
            }
        });

        itemClickListener = (new CoffeeAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int id = coffeeList.get(position).getId();
            }
        });
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<Coffee> coffee) {
        adapter = new CoffeeAdapter(this, coffee, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        coffee = coffeeList;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
