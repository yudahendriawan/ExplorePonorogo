package com.yudahendriawan.exploreponorogo.wisata;

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
import com.yudahendriawan.exploreponorogo.model.Wisata;
import com.yudahendriawan.exploreponorogo.util.Key;

public class DetailWisata extends AppCompatActivity {
    ImageView imageView;
    TextView wisataAddress, wisataName, wisataDescription, wisataLonglat;


    Wisata wisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.image_detail_wisata);
        wisataAddress = findViewById(R.id.wisata_address);
        wisataName = findViewById(R.id.detail_wisata_name);
        wisataDescription = findViewById(R.id.wisata_description);
        wisataLonglat = findViewById(R.id.wisata_longlat_detail);

        wisata = getIntent().getExtras().getParcelable(Key.INTENT_DATA);

        Glide.with(this).load(wisata.getImgUrl()).into(imageView);
        wisataDescription.setText(wisata.getDescription());
        wisataName.setText(wisata.getName());
        wisataAddress.setText(wisata.getAddress());

        wisataLonglat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://maps.google.com/maps?daddr="+wisata.getLonglat()));
                startActivity(intent);
            }
        });
    }
}
