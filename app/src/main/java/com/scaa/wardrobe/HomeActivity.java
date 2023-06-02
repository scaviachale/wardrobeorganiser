package com.scaa.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    UserSession session;
    TextView username;
    BottomNavigationView bottomNavigationView;
    OfferedServices offeredServices = new OfferedServices();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        session = new UserSession(this);

        username = findViewById(R.id.textUsername);
        username.setText(session.getUsername());

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menuHome);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }

        return true;
    }

    public void openWardrobe(View view){
        Intent intent = new Intent(getApplicationContext(), WardrobeActivity.class);
        startActivity(intent);
    }
}