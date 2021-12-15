package com.father_time.clock;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    private static final int CLOCK_FRAGMENT_IDX = 0;
    private static final int ALARM_FRAGMENT_IDX = 1;
    private static final int WORLD_FRAGMENT_IDX = 2;
    private static final int TIMER_FRAGMENT_IDX = 3;
    private static final int STOPWATCH_FRAGMENT_IDX = 4;

    private ViewPager2 viewPager;
    private BottomNavigationView topNavigationView;
    private FragmentStateAdapter pageAdapter;

    @SuppressWarnings("deprecation")
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.pager_two);
        topNavigationView = findViewById(R.id.top_navigation);
//        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        topNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_clock:
                    viewPager.setCurrentItem(CLOCK_FRAGMENT_IDX);
                    return true;
                case R.id.nav_alarm:
                    viewPager.setCurrentItem(ALARM_FRAGMENT_IDX, true);
                    return true;
                case R.id.nav_world:
                    viewPager.setCurrentItem(WORLD_FRAGMENT_IDX, true);
                    return true;
                case R.id.nav_timer:
                    viewPager.setCurrentItem(TIMER_FRAGMENT_IDX, true);
                    return true;
                case R.id.nav_stopwatch:
                    viewPager.setCurrentItem(STOPWATCH_FRAGMENT_IDX, true);
                    return true;

                default:
                    return false;
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

  /*  private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case ALARM_FRAGMENT_IDX:
                    return new Alarm();
                case WORLD_FRAGMENT_IDX:
                    return new Clock();
                case TIMER_FRAGMENT_IDX:
                    return new TimerPage();
                case STOPWATCH_FRAGMENT_IDX:
                    return new StopwatchPage();
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
