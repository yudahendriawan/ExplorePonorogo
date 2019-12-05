package com.yudahendriawan.exploreponorogo.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.yudahendriawan.exploreponorogo.R;
import com.yudahendriawan.exploreponorogo.model.Food;
import com.yudahendriawan.exploreponorogo.util.Key;

import java.util.List;

public class FoodActivity extends AppCompatActivity implements FoodView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    FoodPresenter presenter;
    FoodAdapter adapter;
    FoodAdapter.ItemClickListener itemClickListener;
    List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        getSupportActionBar().setTitle(Key.TITLE_FOOD);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.recyclerview);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new FoodPresenter(this);
        presenter.getData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
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
    public void onGetResult(List<Food> food) {
        adapter = new FoodAdapter(this, food, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        food = foodList;

    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
