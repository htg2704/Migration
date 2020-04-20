package com.example.migration.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class PlanDB extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "PLAN_PROFILE";
    private static final String COL1 = "ID";
    private static final String COL2 = "where_for_job";
    private static final String COL3 = "skil_need";
    private static final String COL4 = "support_lockdown";
    private static final String COL5 = "safety_net";
    private static final String COL6 = "one_stop";
    private static final String COL7 = "distant_work";
    private static final String COL8 = "affordable_housing";
    private static final String COL9 = "healthcare";
    private static final String COL10 = "schooling";
    private static final String COL11 = "skill_upgrade";
    private static final String COL12 = "availability_for_training";
    private static final String COL13 = "present_livelihood";

    public PlanDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 +" TEXT,"
                + COL7 +" TEXT,"+ COL8 +" TEXT,"+ COL9 + " TEXT,"+ COL10 +" TEXT,"+ COL11 +" TEXT,"+ COL13 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME+";");
        onCreate(db);
    }
    public boolean addData(String where_for_job,String skil_need,String support_lockdown,String safety_net,String one_stop,String distant_work,
                           String affordable_housing,String healthcare,String school,String skill_upgrade,String availability_for_training,String present_livelihood) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, where_for_job);
        contentValues.put(COL3, skil_need);
        contentValues.put(COL4, support_lockdown);
        contentValues.put(COL5, safety_net);
        contentValues.put(COL6, one_stop);
        contentValues.put(COL7, distant_work);
        contentValues.put(COL8, affordable_housing);
        contentValues.put(COL9, healthcare);
        contentValues.put(COL10, school);
        contentValues.put(COL11, skill_upgrade);
        contentValues.put(COL12, availability_for_training);
        contentValues.put(COL13,present_livelihood);

        Log.d(TAG, "addData: Adding " +where_for_job+ " to " + TABLE_NAME);

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
    public Cursor getLastData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY ID DESC LIMIT 1";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
