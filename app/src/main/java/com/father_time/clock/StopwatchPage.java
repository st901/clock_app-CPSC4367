package com.father_time.clock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class StopwatchPage extends Fragment {

    public StopwatchPage() {
        // Required empty public constructor
    }

    public static StopwatchPage newInstance() {
        return new StopwatchPage();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -2);

        MyAnalogClock vectorAnalogClock = requireView().findViewById(R.id.big_clock);

        //customization
        vectorAnalogClock.setCalendar(calendar)
                .setDiameterInDp(400.0f)
                .setOpacity(1.0f)
                .setShowSeconds(true)
                .setColor(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }
}



