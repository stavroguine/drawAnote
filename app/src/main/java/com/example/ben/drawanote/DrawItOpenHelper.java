package com.example.ben.drawanote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ben.drawanote.DrawItDatabaseContract.DocEntry;

public class DrawItOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DrawIt.db";
    public static final int DATABASE_VERSION = 2;
    public DrawItOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DocEntry.SQL_CREATE_TABLE);
        db.execSQL(DocEntry.SQL_CREATE_INDEX1);

        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertSampleDocs();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 2) {
            db.execSQL(DocEntry.SQL_CREATE_INDEX1);
        }
    }
}
