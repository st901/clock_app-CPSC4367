package com.father_time.clock;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolderAlarm extends RecyclerView.ViewHolder {

    private final TextView view;

    public RecyclerViewHolderAlarm(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.randomText);
    }

    public TextView getView() {
        return view;
    }

}
