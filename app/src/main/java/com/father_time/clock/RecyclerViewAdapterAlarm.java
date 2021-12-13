package com.father_time.clock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.father_time.clock.R;
import com.father_time.clock.RecyclerViewHolderAlarm;

import java.util.Random;

public class RecyclerViewAdapterAlarm extends RecyclerView.Adapter<RecyclerViewHolderAlarm> {
    private Random random;

    public RecyclerViewAdapterAlarm(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.list_alarm;
    }

    @NonNull
    @Override
    public RecyclerViewHolderAlarm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolderAlarm(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderAlarm holder, int position) {
        holder.getView().setText(String.valueOf(random.nextInt()));
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
