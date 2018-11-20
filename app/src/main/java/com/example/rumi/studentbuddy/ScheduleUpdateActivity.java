package com.example.rumi.studentbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.rumi.studentbuddy.DbHelper.ScheduleDbHelper;

import java.util.ArrayList;
import java.util.List;

public class ScheduleUpdateActivity extends AppCompatActivity {

    private Spinner daySpinnerUpdate, itemSpinnerUpdate;
    private Button updateButton;
    private TimePicker timePickerUpdate;
    private ScheduleDbHelper scheduleDbHelper;
    private TextView subjectTextViewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_update);
        scheduleDbHelper = new ScheduleDbHelper(this);

        daySpinnerUpdate = findViewById(R.id.daySpinnerUpdate);
        itemSpinnerUpdate = findViewById(R.id.itemSpinnerUpdate);
        updateButton = findViewById(R.id.updateButton);
        timePickerUpdate = findViewById(R.id.timePickerUpdate);
        subjectTextViewUpdate = findViewById(R.id.subjectTextViewUpdate);

        final String id = getIntent().getStringExtra("id");
        String day = getIntent().getStringExtra("day");
        String item = getIntent().getStringExtra("item");
        String subject = getIntent().getStringExtra("subject");
        String time = getIntent().getStringExtra("time");

        subjectTextViewUpdate.setText(subject);

        // setting up spinners
        setupSpinners();

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = daySpinnerUpdate.getSelectedItem().toString();
                String item = itemSpinnerUpdate.getSelectedItem().toString();
                String subject = subjectTextViewUpdate.getText().toString();
                String time = timePickerUpdate.getCurrentHour().toString() + " : " + timePickerUpdate.getCurrentMinute().toString();

                if (!TextUtils.isEmpty(day) && !TextUtils.isEmpty(subject) && !TextUtils.isEmpty(item) && !TextUtils.isEmpty(time)) {
                    if (scheduleDbHelper.updateById(id, day, item, subject, time)) {
                        Toast.makeText(getApplicationContext(), "Schedule updated", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(getApplicationContext(), SchedulerActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "All field are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupSpinners() {
        List<String> days = new ArrayList<>();
        days.add("Saturday");
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinnerUpdate.setAdapter(dataAdapter);

        List<String> items = new ArrayList<>();
        items.add("Assignment");
        items.add("Class test");
        items.add("Viva");
        items.add("Notes");
        items.add("Interview");
        items.add("Mid Term Examination");
        items.add("Final Examination");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinnerUpdate.setAdapter(dataAdapter2);
    }
}
