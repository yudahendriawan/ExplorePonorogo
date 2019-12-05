package com.yudahendriawan.exploreponorogo.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yudahendriawan.exploreponorogo.R;
import com.yudahendriawan.exploreponorogo.model.Food;
import com.yudahendriawan.exploreponorogo.util.Key;

public class DetailFood extends AppCompatActivity {

    ImageView imageView;
    TextView foodAddress, foodName, foodDescription, foodLonglat;

    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.image_detail_food);
        foodAddress = findViewById(R.id.food_address_detail);
        foodName = findViewById(R.id.detail_food_name);
        foodDescription = findViewById(R.id.food_detail_description);
        foodLonglat = findViewById(R.id.food_longlat_detail);

        food = getIntent().getExtras().getParcelable(Key.INTENT_DATA);

        Glide.with(this).load(food.getImgUrl()).into(imageView);
        foodAddress.setText(food.getAddress());
        foodName.setText(food.getName());
        foodDescription.setText(food.getDescription());

        foodLonglat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Key.GOOGLE_MAPS_URI + food.getLonglat()));
                startActivity(intent);
            }
        });

        //  getSupportActionBar().setTitle(food.getName());
        getSupportActionBar().hide();
    }
}
