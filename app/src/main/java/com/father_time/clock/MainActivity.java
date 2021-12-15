package com.father_time.clock;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView topNavigationView;
    private FragmentContainerView Clock;
    private FragmentContainerView Alarm;
    private FragmentContainerView World;
    private FragmentContainerView Timer;
    private FragmentContainerView Stopwatch;

    @SuppressWarnings("deprecation")
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clock = findViewById(R.id.ClockView);
        Alarm = findViewById(R.id.AlarmView);
        World = findViewById(R.id.WorldView);
        Timer = findViewById(R.id.TimerView);
        Stopwatch = findViewById(R.id.StopwatchView);

        topNavigationView = findViewById(R.id.top_navigation);
        topNavigationView.setOnNavigationItemSelectedListener(item -> {
            Clock.setVisibility(View.GONE);
            Alarm.setVisibility(View.GONE);
            World.setVisibility(View.GONE);
            Timer.setVisibility(View.GONE);
            Stopwatch.setVisibility(View.GONE);
            switch (item.getItemId()) {
                case R.id.nav_clock:
                    Clock.setVisibility(View.VISIBLE);
                    return true;
                case R.id.nav_alarm:
                    Alarm.setVisibility(View.VISIBLE);
                    return true;
                case R.id.nav_world:
                    World.setVisibility(View.VISIBLE);
                    return true;
                case R.id.nav_timer:
                    Timer.setVisibility(View.VISIBLE);
                    return true;
                case R.id.nav_stopwatch:
                    Stopwatch.setVisibility(View.VISIBLE);
                    return true;

                default:
                    return false;
            }
        });
    }

}
