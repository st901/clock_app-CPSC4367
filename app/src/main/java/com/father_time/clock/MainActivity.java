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
    // TODO 05. We store a reference to our new BottomNavigationView
    private BottomNavigationView topNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager = findViewById(R.id.pager_two);
        topNavigationView = findViewById(R.id.top_navigation);
 //       pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        // TODO 06. Make sure we have already created a view pager
        // TODO 07. Create and add a OnNavigationItemSelectedListener to the BottomNavigationView
        topNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // TODO 08. We'll have to set the current page of the view pager based on the
                //  id of the currently selected menu item in the BottomNavigationView
                switch (item.getItemId()) {
                    case R.id.nav_clock:
                        viewPager.setCurrentItem(CLOCK_FRAGMENT_IDX);
                        // TODO 10. We can associate a badge with a menu item
                        incrementBadgeValue();
                        return true;
                    case R.id.nav_alarm:
                        viewPager.setCurrentItem(ALARM_FRAGMENT_IDX, true);
                        return true;
                    default:
                        return false;
                }
            }
        });
        // TODO 09. We'll have to register a new OnPageChangeCallback to set the corresponding tab
        //  whenever the user makes a swipe gesture and changes the current selected page.
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // TODO 09.01. We get the MenuItem in the given position
                MenuItem selectedItem = topNavigationView.getMenu().getItem(position);
                // TODO 09.02. We set the selected item id of the bottom navigation menu
                topNavigationView.setSelectedItemId(selectedItem.getItemId());
            }
        });
    }

    // TODO 10. We can associate a badge with a menu item and modify the number within
    private void incrementBadgeValue() {
        BadgeDrawable badge = topNavigationView.getOrCreateBadge(R.id.nav_clock);
        badge.setNumber(badge.getNumber() + 1);
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
