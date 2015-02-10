package com.HishaTech.android.rearrange.db;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by smithkev on 2/9/2015.
 */
public class FillTable {

    public static void Words(Context context, String FileName) {

        DbAdapter db = new DbAdapter(context);
        db.open();
        db.insertBulkWords(context, FileName);
        db.close();

    }

}
