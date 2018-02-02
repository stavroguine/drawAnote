package com.example.ben.drawanote;

import android.provider.BaseColumns;

/**
 * Created by Jim.
 */

public final class DrawItDatabaseContract {
    private DrawItDatabaseContract() {} // make non-creatable

    public static final class DocEntry implements BaseColumns {
        public static final String TABLE_NAME = "doc";
        public static final String COLUMN_DOC_TITLE = "doc_title";

        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_DOC_TITLE + ")";


        public static final String getQName(String columnName) {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_DOC_TITLE + " TEXT NOT NULL )";
    }

}












