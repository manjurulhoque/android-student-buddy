package com.example.rumi.studentbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rumi.studentbuddy.DbHelper.NoteDbHelper;

public class CreateNoteActivity extends AppCompatActivity {

    Button btnSave;
    EditText editTextNewNote;
    NoteDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnSave = findViewById(R.id.btnSave);
        editTextNewNote = findViewById(R.id.editTextNewNote);

        dbHelper = new NoteDbHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = editTextNewNote.getText().toString();
                if (!TextUtils.isEmpty(note)) {
                    if (dbHelper.addData(note)) {
                        Toast.makeText(getApplicationContext(), "Note added", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(CreateNoteActivity.this, NotesActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                startActivity(new Intent(this, NotesActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
