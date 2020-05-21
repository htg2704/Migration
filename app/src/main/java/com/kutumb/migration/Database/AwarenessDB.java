package com.kutumb.migration.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class AwarenessDB extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "Awareness_PROFILE";
    private static final String COL1 = "ID";
    private static final String COL2 = "govt_ben";
    private static final String COL3 = "covid_know";
    private static final String COL4 = "lock_know";
    private static final String COL5 = "support_needed";
    private static final String COL6 = "covid_self";
    private static final String COL7 = "schema";
    private static final String COL8 = "otherproblem";
    private static final String COL9 = "suggestion";
    private static final String COL10 = "othersupportreceive";





    public AwarenessDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT,"+ COL3 +" TEXT,"+ COL4 +" TEXT,"+ COL5 +" TEXT,"+ COL6 +" TEXT,"
                + COL7 +" TEXT,"+ COL8 +" TEXT,"+ COL9 + " TEXT,"+ COL10 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+TABLE_NAME+";");
        onCreate(db);
    }
    public boolean addData(String govt_ben,String covid_know,String lock_knw,String support_needed,String covid_self,
                           String schema,String otherproblem,String suggestion,String othersupportreceive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, govt_ben);
        contentValues.put(COL3, covid_know);
        contentValues.put(COL4, lock_knw);
        contentValues.put(COL5, support_needed);
        contentValues.put(COL6, covid_self);
        contentValues.put(COL7, schema);
        contentValues.put(COL8, otherproblem);
        contentValues.put(COL9, suggestion);
        contentValues.put(COL10, othersupportreceive);


        Log.d(TAG, "addData: Adding " +govt_ben+ " to " + TABLE_NAME);

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
