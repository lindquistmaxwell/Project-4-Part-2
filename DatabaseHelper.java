package com.example.max.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by administrator on 3/27/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pairs.db";
    private static final String TABLE_NAME = "pairs";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_ANT = "ant";
    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (id integer primary key not null , " +
            "word text not null, ant text not null)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    public void insertPair(Pairs p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_WORD, p.getWord());
        values.put(COLUMN_ANT, p.getAnt());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPair(String word) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "Not Found";

        if(cursor.moveToFirst()) {
            while(cursor.moveToNext()) {
                a = cursor.getString(1);
                if(a.equals(word)) {
                    b = cursor.getString(2);
                    break;
                }
            }
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }

}
