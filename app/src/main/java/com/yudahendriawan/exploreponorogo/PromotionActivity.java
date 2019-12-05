package com.yudahendriawan.exploreponorogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yudahendriawan.exploreponorogo.util.Key;

public class PromotionActivity extends AppCompatActivity {

    TextView email;
    Button copy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        email = findViewById(R.id.email);
        copy = findViewById(R.id.copy_button);

        getSupportActionBar().setTitle(Key.TITLE_PROMOTION);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("label", email.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(v.getContext(), "Save to clipboard", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
