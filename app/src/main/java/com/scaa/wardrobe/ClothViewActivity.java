package com.scaa.wardrobe;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.scaa.wardrobe.databinding.ActivityClothViewBinding;

public class ClothViewActivity extends AppCompatActivity {

    ActivityClothViewBinding clothViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clothViewBinding = ActivityClothViewBinding.inflate(getLayoutInflater());
        setContentView(clothViewBinding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null) {
            String clothName = intent.getStringExtra("clothName");
            String clothType = intent.getStringExtra("clothType");
            String clothColor = intent.getStringExtra("clothColor");
            String clothSize = intent.getStringExtra("clothSize");
            String clothId = intent.getStringExtra("clothId");
            String clothSeason = intent.getStringExtra("clothSeason");
            int imageId = intent.getIntExtra("imageId", R.drawable.icon_coat);

            //clothViewBinding.
        }

    }
}