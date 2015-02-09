package com.HishaTech.android.rearrange;

import android.content.Context;

import com.HishaTech.android.rearrange.db.DbConstants;

import java.io.File;

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

}
