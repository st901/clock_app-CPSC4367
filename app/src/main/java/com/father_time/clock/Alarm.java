package com.father_time.clock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Alarm extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
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