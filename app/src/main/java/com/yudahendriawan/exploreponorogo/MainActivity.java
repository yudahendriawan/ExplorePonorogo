package com.yudahendriawan.exploreponorogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yudahendriawan.exploreponorogo.Wisata.WisataActivity;

public class MainActivity extends AppCompatActivity {

    CardView holiday;
    CardView caffeResto;
    CardView food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        holiday = findViewById(R.id.holiday);

        holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WisataActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
