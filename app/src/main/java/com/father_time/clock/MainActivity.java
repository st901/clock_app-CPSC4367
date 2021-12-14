package com.father_time.clock;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 2;

    private static final int CLOCK_FRAGMENT_IDX = 0;
    private static final int ALARM_FRAGMENT_IDX = 1;

    private ViewPager2 viewPager;
    private FragmentStateAdapter pageAdapter;
    private BottomNavigationView topNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager = findViewById(R.id.pager_two);
        topNavigationView = findViewById(R.id.top_navigation);
 //       pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        topNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_clock:
                        viewPager.setCurrentItem(CLOCK_FRAGMENT_IDX);
                        return true;
                    case R.id.nav_alarm:
                        viewPager.setCurrentItem(ALARM_FRAGMENT_IDX, true);
                        return true;
                    default:
                        return false;
                }
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                MenuItem selectedItem = topNavigationView.getMenu().getItem(position);
                topNavigationView.setSelectedItemId(selectedItem.getItemId());
            }
        });
    }

   /* private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case CLOCK_FRAGMENT_IDX:
                    return new Clock();
                case ALARM_FRAGMENT_IDX:
                    return new Alarm();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    } */
}
