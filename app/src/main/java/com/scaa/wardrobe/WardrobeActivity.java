package com.scaa.wardrobe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.scaa.wardrobe.entities.ClothesActivity;

public class WardrobeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    UserSession session;
    OfferedServices offeredServices = new OfferedServices();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe);
        session = new UserSession(this);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menuHome);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.menuHome:

                break;// action with ID action_refresh was selected
            case R.id.menuToday:

                break;// action with ID action_refresh was selected
            case R.id.menuServices:
                getSupportFragmentManager().beginTransaction().replace(R.id.offeredServicesFragment, offeredServices).commit();
                break;
            // action with ID action_settings was selected
            case R.id.menuLogout:
                session.logoutUser();
                Toast.makeText(WardrobeActivity.this, "LogOut Successful", Toast.LENGTH_SHORT).show();
                Intent logoutIntent = new Intent(getApplicationContext(), LoginActivity.class);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    public void viewClothes(View view) {
        Intent intent = new Intent(WardrobeActivity.this, ClothesActivity.class);
        startActivity(intent);
    }
}