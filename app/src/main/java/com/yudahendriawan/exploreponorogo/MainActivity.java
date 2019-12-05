package com.yudahendriawan.exploreponorogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.yudahendriawan.exploreponorogo.coffee.CoffeeActivity;
import com.yudahendriawan.exploreponorogo.wisata.WisataActivity;

public class MainActivity extends AppCompatActivity {

    CardView holiday;
    CardView caffeResto;
    CardView food;
    String url = "http://maps.google.com/maps?daddr=-7.795852, 111.631796";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

      //  getSupportActionBar().hide();

        holiday = findViewById(R.id.holiday);
        caffeResto = findViewById(R.id.coffee);
        food = findViewById(R.id.food);
        holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WisataActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        caffeResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CoffeeActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


    }
}
