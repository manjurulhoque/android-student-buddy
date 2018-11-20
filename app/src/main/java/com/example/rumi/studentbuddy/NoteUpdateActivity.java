package com.example.rumi.studentbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rumi.studentbuddy.DbHelper.NoteDbHelper;
import com.example.rumi.studentbuddy.Models.Note;

public class NoteUpdateActivity extends AppCompatActivity {

    EditText editTextUpdateNote;
    Button btnUpdate;
    NoteDbHelper noteDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        noteDbHelper = new NoteDbHelper(this);

        btnUpdate = findViewById(R.id.btnUpdate);
        editTextUpdateNote = findViewById(R.id.editTextUpdateNote);

        String note = getIntent().getStringExtra("note");
        final String id = getIntent().getStringExtra("id");
        editTextUpdateNote.setText(note);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateNote = editTextUpdateNote.getText().toString();
                if(noteDbHelper.updateById(id, updateNote)){
                    Toast.makeText(getApplicationContext(), "Note updated", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(NoteUpdateActivity.this, NotesActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_SHORT).show();
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
