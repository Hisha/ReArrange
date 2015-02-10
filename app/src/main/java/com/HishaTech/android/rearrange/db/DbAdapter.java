package com.HishaTech.android.rearrange.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.HishaTech.android.rearrange.db.model.Words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by smithkev on 2/9/2015.
 */
public class DbAdapter {

    //region ** DbAdapter Main Code **
    private final Context mCtx;
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    // Inner private class. Database Helper class for creating and updating
    // database
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DbConstants.DATABASE_NAME, null,
                    DbConstants.DATABASE_VERSION);
        }

        // onCreate method is called for the 1st time when database doesn't
        // exist
        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(DbConstants.TAG, "Creating Database: " + DbConstants
                    .DATABASE_NAME);
            db.execSQL(DbConstants.WORDS_TABLE_CREATE_STRING);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            Log.w(DbConstants.TAG, "Upgrading " + DbConstants.DATABASE_NAME
                    + " from version "
                    + oldVersion + " to " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS '" + DbConstants
                    .TABLE_WORDS + "'");
            onCreate(db);
        }
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     *
     * @param ctx the Context within which to work
     */
    public DbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * This method is used for creating/opening connection
     *
     * @return instance of DatabaseUtil
     * @throws SQLException
     */
    public DbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    /**
     * This method is used for closing the connection.
     */
    public void close() {
        mDbHelper.close();
    }
    //endregion

    //region ** Words Table related **

    public long insertWord(Words words) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(DbConstants.WORDS_ROWID, words.getID());
        initialValues.put(DbConstants.WORDS_WORD, words.getWord());
        initialValues.put(DbConstants.WORDS_LETTERCOUNT,
                words.getLetterCount());
        return mDb.insert(DbConstants.TABLE_WORDS, null, initialValues);
    }

    public Words getWordById(Integer Id) {
        Words words = new Words();
        Cursor mCursor = mDb.query(DbConstants.TABLE_WORDS,
                new String[]{DbConstants.WORDS_WORD,
                        DbConstants.WORDS_LETTERCOUNT},
                DbConstants.WORDS_ROWID + " = ?",
                new String[]{Integer.toString(Id)}, null, null, null);
        if (mCursor.moveToFirst()) {
            do {
                words.setID(Id);
                words.setWord(mCursor.getString(mCursor.getColumnIndex
                        (DbConstants.WORDS_WORD)));
                words.setLetterCount(mCursor.getInt(mCursor
                        .getColumnIndex(DbConstants.WORDS_LETTERCOUNT)));
            } while (mCursor.moveToNext());
        }
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        return words;
    }

    public Words getRandomWord(Integer LetterCount) {

        Cursor mCursor;

        if (LetterCount == 0) {

            mCursor = mDb.query(DbConstants.TABLE_WORDS,
                    new String[]{DbConstants.WORDS_ROWID,
                            DbConstants.WORDS_WORD,
                            DbConstants.WORDS_LETTERCOUNT}, null,
                    null, null, null, "RANDOM()", "1");
        } else {
            mCursor = mDb.query(DbConstants.TABLE_WORDS,
                    new String[]{DbConstants.WORDS_ROWID,
                            DbConstants.WORDS_WORD,
                            DbConstants.WORDS_LETTERCOUNT},
                    DbConstants.WORDS_LETTERCOUNT + " = ?",
                    new String[]{String.valueOf(LetterCount)}, null,
                    null,
                    "RANDOM()",
                    "1");
        }

        Words words = new Words();

        if (mCursor.moveToFirst()) {
            do {
                words.setID(mCursor.getInt(mCursor.getColumnIndex
                        (DbConstants.WORDS_ROWID)));
                words.setWord(mCursor.getString(mCursor.getColumnIndex
                        (DbConstants.WORDS_WORD)));
                words.setLetterCount(mCursor.getInt(mCursor
                        .getColumnIndex(DbConstants.WORDS_LETTERCOUNT)));
            } while (mCursor.moveToNext());
        }
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        return words;

    }

    public void insertBulkWords(Context context, String FileName) {

        BufferedReader br = null;
        try {
            AssetManager am = context.getAssets();
            InputStream is = am.open(FileName);
            br = new BufferedReader(new InputStreamReader(is), 1024 * 4);
            String line = null;
            mDb.beginTransaction();
            while ((line = br.readLine()) != null) {
                mDb.execSQL(line);
            }
            mDb.setTransactionSuccessful();
        } catch (IOException e) {
            Log.e(DbConstants.TAG, "read database init file error");
        } finally {
            mDb.endTransaction();
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Log.e(DbConstants.TAG, "buffer reader close error");
                }
            }
        }

    }

    public boolean checkWordExistsByWord(String Word) {
        String SQLQuery = "SELECT * FROM " + DbConstants.TABLE_WORDS +
                " WHERE " + DbConstants.WORDS_WORD + " =?";
        Cursor mCursor = mDb.rawQuery(SQLQuery, new String[]{Word});
        boolean exists = (mCursor.getCount() > 0);
        mCursor.close();
        return exists;
    }

    //endregion
}
