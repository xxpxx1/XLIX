package com.xlix;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xlix.ui.home.HomeFragment;
import com.xlix.ui.control.ControlFragment;
import com.xlix.ui.vault.VaultFragment;
import com.xlix.ui.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment selected = null;
            int id = item.getItemId();

            if (id == R.id.navigation_home) {
                selected = new HomeFragment();
            } else if (id == R.id.navigation_control) {
                selected = new ControlFragment();
            } else if (id == R.id.navigation_vault) {
                selected = new VaultFragment();
            } else if (id == R.id.navigation_settings) {
                selected = new SettingsFragment();
            }

            if (selected != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selected)
                        .commit();
            }

            return true;
        });

        // default fragment saat pertama kali dibuka
        if (savedInstanceState == null) {
            bottomNavigation.setSelectedItemId(R.id.navigation_home);
        }
    }
}
