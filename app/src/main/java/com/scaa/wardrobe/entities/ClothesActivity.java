package com.scaa.wardrobe.entities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.scaa.wardrobe.ClothViewActivity;
import com.scaa.wardrobe.R;
import com.scaa.wardrobe.databinding.ActivityClothesBinding;

import java.util.ArrayList;

public class ClothesActivity extends AppCompatActivity {

    ActivityClothesBinding activityClothesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityClothesBinding = ActivityClothesBinding.inflate(getLayoutInflater());
        setContentView(activityClothesBinding.getRoot());

        int[] imageId = {R.drawable.icon_coat, R.drawable.icon_shorts};
        String[] clothName = {"jazi", "tshava"};
        String[] clothType = {"jacket", "thsirt"};
        String[] clothColor = {"blue", "red"};
        String[] clothSize = {"XL", "S"};
        String[] clothId = {"1", "2"};
        String[] clothSeason = {"Summer", "Winter"};

        ArrayList<Cloth> cloths = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++) {
            Cloth cloth = new Cloth(
                    imageId[i],
                    clothName[i],
                    clothId[i],
                    clothType[i],
                    clothSize[i],
                    clothColor[i],
                    clothSeason[i]);
            cloths.add(cloth);

        }

        ListAdapter listAdapter = new ListAdapter(ClothesActivity.this, cloths);
        activityClothesBinding.clothesListView.setAdapter(listAdapter);
        activityClothesBinding.clothesListView.setClickable(true);
        activityClothesBinding.clothesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent clothIntent = new Intent(ClothesActivity.this, ClothViewActivity.class);
                clothIntent.putExtra("clothName", clothName[position]);
                clothIntent.putExtra("clothType", clothType[position]);
                clothIntent.putExtra("clothColor", clothColor[position]);
                clothIntent.putExtra("clothSize", clothSize[position]);
                clothIntent.putExtra("clothId", clothId[position]);
                clothIntent.putExtra("clothSeason", clothSeason[position]);
                startActivity(clothIntent);
            }
        });
    }
}