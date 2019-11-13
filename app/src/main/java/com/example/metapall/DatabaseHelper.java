package com.example.metapall;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Personal.db";
    public static final String TABLE_NAME = "Personal_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "HEIGHT";
    public static final String COL3 = "WEIGHT";
    public static final String COL4 = "AGE";
    public static final String COL5 = "GENDER";
    public static final String COL6 = "ACTIVITY";
    //public static final String COL7 = "BMR";
    //public static final String COL8 = "DTEE";


    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "HEIGHT TEXT, WEIGHT TEXT, AGE TEXT, GENDER TEXT, ACTIVITY TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String HEIGHT, String WEIGHT, String AGE, String GENDER, String ACTIVITY){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,HEIGHT);
        contentValues.put(COL3,WEIGHT);
        contentValues.put(COL4,AGE);
        contentValues.put(COL5,GENDER);
        contentValues.put(COL6,ACTIVITY);
        //contentValues.put(COL7,BMR);
        //contentValues.put(COL8,DTEE);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
