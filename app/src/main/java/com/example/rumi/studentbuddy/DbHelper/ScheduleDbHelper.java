package com.example.rumi.studentbuddy.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rumi.studentbuddy.Constants.DB;
import com.example.rumi.studentbuddy.Models.Schedule;

import java.util.ArrayList;
import java.util.List;


public class ScheduleDbHelper extends SQLiteOpenHelper {
    private static final String COL1 = "ID";
    private static final String COL2 = "day";
    private static final String COL3 = "item";
    private static final String COL4 = "subject";
    private static final String COL5 = "time";

    public ScheduleDbHelper(Context context) {
        super(context, DB.TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DB.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DB.TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String day, String item, String subject, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, day);
        contentValues.put(COL3, item);
        contentValues.put(COL4, subject);
        contentValues.put(COL5, time);

        long result = db.insert(DB.TABLE_NAME, null, contentValues);

        return result != -1;
    }

    public List<Schedule> getAll() {
        List<Schedule> schedules = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + DB.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String id = String.valueOf(cursor.getInt(0));
            String day = cursor.getString(1);
            String item = cursor.getString(2);
            String subject = cursor.getString(3);
            String time = cursor.getString(4);
            Schedule schedule = new Schedule(id, day, item, subject, time);
            schedules.add(schedule);
        }

        cursor.close();

        return schedules;
    }

    public boolean deleteById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete(DB.TABLE_NAME, "ID=?", new String[]{id}) > 0;
    }

    public boolean updateById(String id, String day, String item, String subject, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, day);
        contentValues.put(COL3, item);
        contentValues.put(COL4, subject);
        contentValues.put(COL5, time);
        return db.update(DB.TABLE_NAME, contentValues, "ID=" + id, null) > 0;
    }
}
