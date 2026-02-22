package com.hartonostudio.donasiappsmadania;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hartonostudio.donasiappsmadania.Menu.Home.HomeFragment;
import com.hartonostudio.donasiappsmadania.Menu.Profil.ProfilFragment;
import com.hartonostudio.donasiappsmadania.Menu.Program.ProgramFragment;
import com.hartonostudio.donasiappsmadania.databinding.ActivityMainBinding;

import java.util.Objects;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setToolbar();
        initViews(savedInstanceState);
        initComponentsNavHeader();
    }

    private void setToolbar() {
        setSupportActionBar(binding.appBar.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
    }

    @SuppressLint("NonConstantResourceId")
    private void initViews(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            binding.navigation.selectTabById(R.id.nav_menu_home, true);
            loadFragment(new HomeFragment());
        }

        binding.navigation.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, AnimatedBottomBar.Tab lastTab, int newIndex, AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                int tabId = newTab.getId();

                if (tabId == R.id.nav_menu_home) {
                    fragment = new HomeFragment();
                } else if (tabId == R.id.nav_menu_wishlist) {
                    fragment = new ProgramFragment();
                } else if (tabId == R.id.nav_menu_signin) {
                    fragment = new ProfilFragment();
                }

                if (fragment != null) {
                    loadFragment(fragment);
                } else {
                    Log.e(TAG, "Error in creating Fragment");
                }
            }

            @Override
            public void onTabReselected(int i, AnimatedBottomBar.Tab tab) {}
        });

        /**
         * Menu Navigation Drawer
         **/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appBar.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(view -> binding.drawerLayout.openDrawer(GravityCompat.START));
        toggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        toggle.syncState();
    }

    private void loadFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void initComponentsNavHeader(){
        binding.navView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_weeds) {
                showToast("Menu Weeds");
            } else if (itemId == R.id.nav_insects) {
                showToast("Menu Insects");
            } else if (itemId == R.id.nav_diseases) {
                showToast("Menu Diseases");
            } else if (itemId == R.id.nav_products) {
                showToast("Menu Products");
            } else if (itemId == R.id.nav_help) {
                showToast("Menu Help");
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void showToast(String pesan) {
        Toast.makeText(MainActivity.this, pesan, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
