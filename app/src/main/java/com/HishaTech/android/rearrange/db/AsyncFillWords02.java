package com.HishaTech.android.rearrange.db;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by smithkev on 2/10/2015.
 */
public class AsyncFillWords02 extends AsyncTask<Context, Void, String> {
    Context mCtx;

    public AsyncFillWords02(Context context) {
        mCtx = context;
    }

    @Override
    protected String doInBackground(Context... params) {
        FillTable.Words(mCtx, DbConstants.WordListFile02);
        return "true";
    }

    @Override
    protected void onPostExecute(String truefalse) {

    }
}