package com.example.migration.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class MyDB extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "MIGRANT_DATA";
    private static final String COL1 = "ID";
    private static final String COL2 = "Name";
    private static final String COL3 = "Age";
    private static final String COL4 = "gender";
    private static final String COL5 = "caste";
    private static final String COL6 = "Pwd";
    private static final String COL7 = "education";
    private static final String COL8 = "pin";
    private static final String COL9 = "Mobile";
    private static final String COL10 = "city";
    private static final String COL11 = "govt_id";
    private static final String COL12 = "dependents";
    private static final String COL13 = "maritialstatus";
    private static final String COL14 = "addskill";




    public MyDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 +" TEXT,"
                + COL7 +" TEXT,"+ COL8 +" DOUBLE,"+ COL9 +" DOUBLE,"+ COL10 +" TEXT,"+ COL11 +" TEXT,"+ COL12 + " TEXT,"+ COL13 + " TEXT,"+ COL14 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME+";");
        onCreate(db);
    }
    public boolean addData(String name,String age,String gender,String caste,String pwd,String edu,Double pin,Double Mobile,String city,String govt_id,String dependent,String maritialstatus,String addskill) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, age);
        contentValues.put(COL4, gender);
        contentValues.put(COL5, caste);
        contentValues.put(COL6, pwd);
        contentValues.put(COL7, edu);
        contentValues.put(COL8, pin);
        contentValues.put(COL9, Mobile);
        contentValues.put(COL10, city);
        contentValues.put(COL11, govt_id);
        contentValues.put(COL12, dependent);
        contentValues.put(COL13, maritialstatus);
        contentValues.put(COL14, addskill);



        Log.d(TAG, "addData: Adding " +name+ " to " + TABLE_NAME);

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
