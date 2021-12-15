package com.father_time.clock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Alarm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Alarm extends Fragment {

    public Alarm() {}

    public static Alarm newInstance() {
        return new Alarm();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);
        RecyclerView recyclerViewAlarms = view.findViewById(R.id.rvAlarms);
        recyclerViewAlarms.setHasFixedSize(true);
        recyclerViewAlarms.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerViewAlarms.setAdapter(new RecyclerViewAdapterAlarm(1234));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false);
    }
}