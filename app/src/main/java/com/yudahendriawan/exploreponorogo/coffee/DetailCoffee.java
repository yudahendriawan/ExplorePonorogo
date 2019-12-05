package com.yudahendriawan.exploreponorogo.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yudahendriawan.exploreponorogo.R;
import com.yudahendriawan.exploreponorogo.model.Coffee;
import com.yudahendriawan.exploreponorogo.util.Key;

public class DetailCoffee extends AppCompatActivity {

    ImageView imageView;
    TextView coffeeAddress, coffeeName, coffeeDescription;

    Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_coffee);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.image_detail_coffee);
        coffeeAddress = findViewById(R.id.coffee_address_detail);
        coffeeName = findViewById(R.id.detail_coffee_name);
        coffeeDescription = findViewById(R.id.coffee_detail_description);

        coffee = getIntent().getExtras().getParcelable(Key.INTENT_DATA);

        Glide.with(this).load(coffee.getImgUrl()).into(imageView);
        coffeeAddress.setText(coffee.getAddress());
        coffeeName.setText(coffee.getName());
        coffeeDescription.setText(coffee.getDescription());
    }
}
