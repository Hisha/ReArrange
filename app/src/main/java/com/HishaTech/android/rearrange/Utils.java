package com.HishaTech.android.rearrange;

import android.content.Context;

import com.HishaTech.android.rearrange.db.DbConstants;

import java.io.File;
import java.util.Random;

/**
 * Created by smithkev on 2/9/2015.
 */
public class Utils {

    public static boolean DatabaseExists(Context context) {
        File database = context.getDatabasePath
                (DbConstants
                        .DATABASE_NAME);
        if (!database.exists()) {
            return false;
        } else {
            return true;
        }
    }

    public static String getRandomLetter() {

        String randomLetter = "";

        Random r = new Random();
        int Low = 65;
        int High = 90;
        int R = r.nextInt(High-Low) + Low;

        randomLetter = Character.toString((char)R);

        return randomLetter;

    }

}
