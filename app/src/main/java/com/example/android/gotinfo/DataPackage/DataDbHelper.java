package com.example.android.gotinfo.DataPackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.android.gotinfo.DataPackage.DataContract.DataEntry.COLUMN_NAME;
import static com.example.android.gotinfo.DataPackage.DataContract.DataEntry.TABLE_NAME;

public class DataDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DataDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "recents.db";


    private static final int DATABASE_VERSION = 1;


    public DataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_RECENTS_TABLE = "CREATE TABLE " + DataContract.DataEntry.TABLE_NAME + " ("
                + DataContract.DataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataContract.DataEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DataContract.DataEntry.COLUMN_HOUSE + " TEXT, "
                + DataContract.DataEntry.COLUMN_SPOUSE + " TEXT, "
                + DataContract.DataEntry.COLUMN_TITLES + " TEXT);";

        db.execSQL(SQL_CREATE_RECENTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean checkIfRecordExist(String chek) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TABLE_NAME, new String[]{BaseColumns._ID,
                            COLUMN_NAME}, COLUMN_NAME + "=?",
                    new String[]{chek}, null, null, null, null);
            if (cursor != null && cursor.getCount() != 0) {
                cursor.moveToFirst();

            }

            if (cursor.moveToFirst()) {
                db.close();
                return true;//record Exists

            }
            db.close();
        } catch (Exception errorException) {
            Log.d(LOG_TAG, "Exception occured " + errorException);
        }
        return false;
    }

    public Long getCharId(String character) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{BaseColumns._ID,
                        COLUMN_NAME}, COLUMN_NAME + "=?",
                new String[]{character}, null, null, null, null);
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToFirst();
            return Long.valueOf(cursor.getString(0));

        } else return null;
    }

    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{BaseColumns._ID,
                COLUMN_NAME}, null, null, null, null, null);
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                names.add(cursor.getString(1));
                cursor.moveToNext();
            }
            Collections.reverse(names);
            return names;

        } else return null;
    }

}
