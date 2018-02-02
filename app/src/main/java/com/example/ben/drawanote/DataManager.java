package com.example.ben.drawanote;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ben.drawanote.DrawItDatabaseContract.DocEntry;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager ourInstance = null;

    private List<Doc> mDocs = new ArrayList<>();

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
            /*ourInstance.initializeDocs();*/
        }
        return ourInstance;
    }

    public static void loadFromDatabase(DrawItOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        final String[] docColumns = {
                DocEntry.COLUMN_DOC_TITLE,
                DocEntry._ID};
        String docOrderBy = DocEntry.COLUMN_DOC_TITLE;
        final Cursor docCursor = db.query(DocEntry.TABLE_NAME, docColumns,
                null, null, null, null, docOrderBy);
        loadDocsFromDatabase(docCursor);
    }

    private static void loadDocsFromDatabase(Cursor cursor) {
        int docTitlePos = cursor.getColumnIndex(DocEntry.COLUMN_DOC_TITLE);
        int idPos = cursor.getColumnIndex(DocEntry._ID);

        DataManager dm = getInstance();
        dm.mDocs.clear();
        while(cursor.moveToNext()) {
            String docTitle = cursor.getString(docTitlePos);
            int id = cursor.getInt(idPos);

            Doc doc = new Doc(id, docTitle);
            dm.mDocs.add(doc);
        }
        cursor.close();
    }

    public List<Doc> getDocs() {
        return mDocs;
    }

    /*public int createNewDoc() {
        Doc doc = new Doc(null);
        mDocs.add(doc);
        return mDocs.size() - 1;
    }*/

    public int findDoc(Doc doc) {
        for(int index = 0; index < mDocs.size(); index++) {
            if(doc.equals(mDocs.get(index)))
                return index;
        }

        return -1;
    }

    public void removeDoc(int index) {
        mDocs.remove(index);
    }

    public int getDocCount() {
        int count = 0;
        for(Doc doc:mDocs) {
            count++;
        }
        return count;
    }

    private DataManager() {
    }

    /*public void initializeDocs() {
        final DataManager dm = getInstance();

        mDocs.add(new Doc("0"));
        mDocs.add(new Doc("1"));
        mDocs.add(new Doc("2"));
        mDocs.add(new Doc("3"));
        mDocs.add(new Doc("4"));
        mDocs.add(new Doc("6"));
        mDocs.add(new Doc("7"));
        mDocs.add(new Doc("8"));
        mDocs.add(new Doc("9"));
        mDocs.add(new Doc("10"));
        mDocs.add(new Doc("11"));
    }*/
}
