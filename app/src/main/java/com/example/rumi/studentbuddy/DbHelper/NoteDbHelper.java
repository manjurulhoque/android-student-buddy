package com.example.rumi.studentbuddy.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.rumi.studentbuddy.Constants.DB;
import com.example.rumi.studentbuddy.Models.Note;
import com.example.rumi.studentbuddy.Models.Schedule;

import java.util.ArrayList;
import java.util.List;

public class NoteDbHelper extends SQLiteOpenHelper {

    private static final String COL_ID = "ID";
    private static final String COL_NOTE = "note";
    private Context context;

    public NoteDbHelper(Context context) {
        super(context, DB.NOTES_TABLE_NAME, null, 1);
        context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DB.NOTES_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NOTE + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DB.NOTES_TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOTE, note);

        long result = db.insert(DB.NOTES_TABLE_NAME, null, contentValues);

        return result != -1;
    }

    public List<Note> getAll() {
        List<Note> notes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + DB.NOTES_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String id = String.valueOf(cursor.getInt(0));
            String text = cursor.getString(1);
            Note note = new Note(id, text);
            notes.add(note);
        }

        cursor.close();

        return notes;
    }

    public boolean deleteById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete(DB.NOTES_TABLE_NAME, "ID=?", new String[]{id}) > 0;
    }

    public boolean updateById(String id, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOTE, note);
        return db.update(DB.NOTES_TABLE_NAME, contentValues, "ID=" + id, null) > 0;
    }
}
