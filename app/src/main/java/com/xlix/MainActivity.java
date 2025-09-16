package com.xlix;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        // default fragment = Home
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selected = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selected = new HomeFragment();
                    break;
                case R.id.navigation_control:
                    selected = new ControlFragment();
                    break;
                case R.id.navigation_vault:
                    selected = new VaultFragment();
                    break;
                case R.id.navigation_settings:
                    selected = new SettingsFragment();
                    break;
            }

            if (selected != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selected)
                        .commit();
            }
            return true;
        });
    }
}
