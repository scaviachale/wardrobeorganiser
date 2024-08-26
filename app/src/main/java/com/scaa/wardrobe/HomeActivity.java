package com.scaa.wardrobe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends WardrobeOrganiserApplicationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = findViewById(R.id.textUsername);
        username.setText(session.getUsername());

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menuHome);
    }
    public void openWardrobe(View view) {
        Intent intent = new Intent(getApplicationContext(), WardrobeActivity.class);
        startActivity(intent);
    }
}