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
    private static final String COL3 = "support_lockdown";
    private static final String COL4 = "skill_upgrade";
    private static final String COL5 = "availability_for_training";
    private static final String COL6 = "present_livelihood";
    private static final String COL7 = "migrate_plan";
    private static final String COL8 = "migrate_support";
    private static final String COL9 = "other_avaibility";
    private static final String COL10 = "other_livelihood";
    private static final String COL11 = "other_support";
    private static final String COL12 = "comment";


    public PlanDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 +" TEXT,"
                + COL7 +" TEXT,"+ COL8 +" TEXT,"+ COL9 + " TEXT,"+ COL10 +" TEXT,"+ COL11 +" TEXT,"+ COL12 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME+";");
        onCreate(db);
    }
    public boolean addData(String where_for_job,String support_lockdown,String skill_upgrade,String availability_for_training,String present_livelihood,
                           String migrate_plan,String migrate_support,String other_avaibility,String other_livelihood,String other_support,String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, where_for_job);
        contentValues.put(COL3, support_lockdown);
        contentValues.put(COL4, skill_upgrade);
        contentValues.put(COL5, availability_for_training);
        contentValues.put(COL6,present_livelihood);
        contentValues.put(COL7,migrate_plan);
        contentValues.put(COL8,migrate_support);
        contentValues.put(COL9,other_avaibility);
        contentValues.put(COL10,other_livelihood);
        contentValues.put(COL11,other_support);
        contentValues.put(COL12,comment);

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
