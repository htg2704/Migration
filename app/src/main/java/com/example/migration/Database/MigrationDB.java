package com.example.migration.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class MigrationDB extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "MIGRANT_PROFILE";
    private static final String COL1 = "ID";
    private static final String COL2 = "nature";
    private static final String COL3 = "location";
    private static final String COL4 = "period";
    private static final String COL5 = "wage";
    private static final String COL6 = "employer";
    private static final String COL7 = "e_no";
    private static final String COL8 = "otherbenefits";
    private static final String COL9 = "challenges";

    public MigrationDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 +" TEXT,"
                + COL7 +" DOUBLE,"+ COL8 +" TEXT,"+ COL9 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME+";");
        onCreate(db);
    }
    public boolean addData(String nature,String location,String period,String wage,String employer,Double emp_no,String other_benefits,String challenges) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, nature);
        contentValues.put(COL3, location);
        contentValues.put(COL4, period);
        contentValues.put(COL5, wage);
        contentValues.put(COL6, employer);
        contentValues.put(COL7, emp_no);
        contentValues.put(COL8, other_benefits);
        contentValues.put(COL9, challenges);


        Log.d(TAG, "addData: Adding " +nature+ " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
