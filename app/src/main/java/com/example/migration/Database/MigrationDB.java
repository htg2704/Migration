package com.example.migration.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.zip.DeflaterOutputStream;

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
    private static final String COL10 = "kindofwork";
    private static final String COL11 = "typechallenge";
    private static final String COL12 = "reason";
    private static final String COL13 = "amount";
    private static final String COL14 = "amounthouse";
    private static final String COL15 = "amountother";
    private static final String COL16 = "amountfood";
    private static final String COL17 = "amounttransport";
    private static final String COL18 = "amounthealth";
    private static final String COL19 = "amountedu";
    private static final String COL20 = "amountloan";




    public MigrationDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 +" TEXT,"
                + COL7 +" DOUBLE,"+ COL8 +" TEXT,"+ COL9 + " TEXT,"+ COL10 + " TEXT,"+ COL11 +" TEXT,"+ COL12 +" TEXT,"+ COL13 +" TEXT,"+ COL14 +" TEXT,"+ COL15 +" TEXT,"+ COL16 +" TEXT,"+ COL17 +" TEXT,"+ COL18 +" TEXT,"+ COL19 +" TEXT,"+ COL20 +" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME+";");
        onCreate(db);
    }
    public boolean addData(String nature, String location, String period, String wage, String employer, Double emp_no, String other_benefits, String challenges, String kindofwork, String typechallenge, String reason, Double amount, Double amounthouse, Double amountother,
                           Double amountfood, Double amounttransport, Double amounthealth,Double amountedu,Double amountloan) {
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
        contentValues.put(COL10, kindofwork);
        contentValues.put(COL11, typechallenge);
        contentValues.put(COL12, reason);
        contentValues.put(COL13, amount);
        contentValues.put(COL14, amounthouse);
        contentValues.put(COL15, amountother);
        contentValues.put(COL16, amountfood);
        contentValues.put(COL17, amounttransport);
        contentValues.put(COL18, amounthealth);
        contentValues.put(COL19, amountedu);
        contentValues.put(COL20, amountloan);


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
    public Cursor getLastData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY ID DESC LIMIT 1";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
