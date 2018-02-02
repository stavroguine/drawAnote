package com.example.ben.drawanote;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertSampleDocs() {
        insertDoc("Doc 1");
        insertDoc("Doc 2");
        insertDoc("Doc 3");
    }

    private void insertDoc(String title) {
        ContentValues values = new ContentValues();
        values.put(DrawItDatabaseContract.DocEntry.COLUMN_DOC_TITLE, title);

        long newRowId = mDb.insert(DrawItDatabaseContract.DocEntry.TABLE_NAME, null, values);
    }

}
