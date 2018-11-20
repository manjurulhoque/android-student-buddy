package com.example.rumi.studentbuddy.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rumi.studentbuddy.Models.Schedule;
import com.example.rumi.studentbuddy.R;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Schedule> schedules = new ArrayList<Schedule>();

    public ScheduleRecyclerViewAdapter(Context context, List<Schedule> schedules) {
        this.context = context;
        this.schedules = schedules;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_schedule_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.newSubjectTextView.setText(schedules.get(position).getSubject());
        holder.itemTextView.setText(schedules.get(position).getItem());
        holder.dayTextView.setText(schedules.get(position).getDay());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView newSubjectTextView, itemTextView, dayTextView;
        RelativeLayout parentLayout;

        ViewHolder(View view) {
            super(view);

            parentLayout = view.findViewById(R.id.parent_layout);
            newSubjectTextView = view.findViewById(R.id.newSubjectTextView);
            itemTextView = view.findViewById(R.id.itemTextView);
            dayTextView = view.findViewById(R.id.dayTextView);
        }
    }
}
