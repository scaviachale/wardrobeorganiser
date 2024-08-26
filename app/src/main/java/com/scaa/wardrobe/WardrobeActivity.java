package com.scaa.wardrobe;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WardrobeActivity extends WardrobeOrganiserApplicationActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menuHome);
    }
}