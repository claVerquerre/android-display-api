package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.myapplication.fragments.GridFragment;
import com.example.myapplication.fragments.MainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(new MainFragment());

        BottomNavigationView nav_view_bottom = findViewById(R.id.nav_view_bottom);
        nav_view_bottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    /**
     * Switch to another fragment.
     * @param fragment th new fragment.
     */
    private void setFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            setFragment(new MainFragment());
        } else if (id == R.id.nav_grid) {
            setFragment(new GridFragment());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * In function of the clicked item, switch on the corresponding fragment.
     */
    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_main:
                        setFragment(new MainFragment());
                        return true;

                    case R.id.nav_grid:
                        menuItem.setChecked(true);
                        setFragment(new GridFragment());
                        return true;
                }
                return false;
            }
        };
}
