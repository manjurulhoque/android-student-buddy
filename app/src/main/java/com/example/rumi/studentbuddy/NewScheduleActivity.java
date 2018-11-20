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

public class NewScheduleActivity extends AppCompatActivity {

    private Spinner daySpinner, itemSpinner;
    private Button saveButton;
    private TimePicker timePicker;
    private ScheduleDbHelper scheduleDbHelper;
    private TextView subjectTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        scheduleDbHelper = new ScheduleDbHelper(this);

        daySpinner = findViewById(R.id.daySpinner);
        itemSpinner = findViewById(R.id.itemSpinner);
        saveButton = findViewById(R.id.saveButton);
        timePicker = findViewById(R.id.timePicker);
        subjectTextView = findViewById(R.id.subjectTextView);

        // setting up spinners
        setupSpinners();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = daySpinner.getSelectedItem().toString();
                String item = itemSpinner.getSelectedItem().toString();
                String subject = subjectTextView.getText().toString();
                String time = timePicker.getCurrentHour().toString() + " : " + timePicker.getCurrentMinute().toString();

                if (!TextUtils.isEmpty(day) && !TextUtils.isEmpty(subject) && !TextUtils.isEmpty(item) && !TextUtils.isEmpty(time)) {
                    if (scheduleDbHelper.addData(day, item, subject, time)) {
                        Toast.makeText(getApplicationContext(), "Schedule added", Toast.LENGTH_SHORT).show();
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
        daySpinner.setAdapter(dataAdapter);

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
        itemSpinner.setAdapter(dataAdapter2);
    }
}
