package com.father_time.clock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class World extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_world, container, false);
        RecyclerView recyclerViewWorld = view.findViewById(R.id.rvAlarms);
        recyclerViewWorld.setHasFixedSize(true);
        recyclerViewWorld.setLayoutManager(new LinearLayoutManager(view.getContext()));
        // recyclerViewWorld.setAdapter(new RecyclerViewAdapterWorld(1234));
        return inflater.inflate(R.layout.fragment_world, container, false);
    }
}