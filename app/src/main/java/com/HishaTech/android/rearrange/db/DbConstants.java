package com.HishaTech.android.rearrange.db;

/**
 * Created by smithkev on 2/9/2015.
 */
public class DbConstants {

    // TAG for Log entries
    public static final String TAG = "DBAdapter";
    // Database name
    public static final String DATABASE_NAME = "rearrange.db";
    // Set the database version for upgrade purposes
    public static final int DATABASE_VERSION = 1;
    // table names used in database
    public static final String TABLE_WORDS = "words";

    // Words table columns
    public static final String WORDS_ROWID = "_id";
    public static final String WORDS_WORD = "word";
    public static final String WORDS_LETTERCOUNT = "lettercount";

    // Words table creation string
    public static final String WORDS_TABLE_CREATE_STRING = "CREATE " +
            "TABLE "
            + TABLE_WORDS
            + " ("
            + WORDS_ROWID
            + " integer primary key, "
            + WORDS_WORD
            + " text not null, "
            + WORDS_LETTERCOUNT
            + " integer not null);";

    // Words table wordlist
    public static final String WordListFile01 = "insertWords01.txt";
    public static final String WordListFile02 = "insertWords02.txt";
    public static final String WordListFile03 = "insertWords03.txt";
    public static final String WordListFile04 = "insertWords04.txt";

}
