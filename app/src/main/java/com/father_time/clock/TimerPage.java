package com.father_time.clock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimerPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimerPage extends Fragment {

    public TimerPage() {
        // Required empty public constructor
    }

    public static TimerPage newInstance() {
        return new TimerPage();
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }
}



