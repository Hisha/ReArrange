package com.HishaTech.android.rearrange.db.table;

import android.content.Context;

import com.HishaTech.android.rearrange.Conversions;
import com.HishaTech.android.rearrange.db.DbAdapter;
import com.HishaTech.android.rearrange.db.model.Words;

/**
 * Created by smithkev on 2/9/2015.
 */
public class table_Words {

    public static boolean insertWord(Context context,
                                     Words words) {
        boolean insertFailed = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        insertFailed = Conversions.TrueFalseIntToBoolean((int) db
                .insertWord
                        (words));
        db.close();
        return insertFailed;
    }

    public static Words getWordById(Context context, Integer WordId) {
        Words words = new Words();
        DbAdapter db = new DbAdapter(context);
        db.open();
        words = db.getWordById(WordId);
        db.close();
        return words;
    }

    public static Words getRandomWord(Context context, Integer LetterCount) {
        Words words = new Words();
        DbAdapter db = new DbAdapter(context);
        db.open();
        words = db.getRandomWord(LetterCount);
        db.close();
        return words;
    }

    public static boolean checkWordExistsByWord(Context context, String Word) {
        boolean recordExists = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        recordExists = db.checkWordExistsByWord(Word);
        db.close();
        return recordExists;
    }

}
