package com.android.akef;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.akef.Adapters.ViewPagerAdapter;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    MaterialViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ViewPager pager = mViewPager.getViewPager();
        pager.setAdapter(mViewPagerAdapter);
        pager.setCurrentItem(1);
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.home_menu){
            mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            ViewPager pager = mViewPager.getViewPager();
            pager.setAdapter(mViewPagerAdapter);
            pager.setCurrentItem(1);
            mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        }
        if(item.getItemId() == R.id.stream_menu){
            mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            ViewPager pager = mViewPager.getViewPager();
            pager.setAdapter(mViewPagerAdapter);
            pager.setCurrentItem(2 );
            mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
            /*Toast.makeText(this,"Home Menu item is clicked", Toast.LENGTH_LONG).show();*/
        }
        if(item.getItemId() == R.id.more_menu){
            mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            ViewPager pager = mViewPager.getViewPager();
            pager.setAdapter(mViewPagerAdapter);
            pager.setCurrentItem(0);
            mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        }
        return false;
    }
}