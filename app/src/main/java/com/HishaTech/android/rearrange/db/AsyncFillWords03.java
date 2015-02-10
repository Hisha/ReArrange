package com.HishaTech.android.rearrange.db;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.HishaTech.android.rearrange.R;

/**
 * Created by smithkev on 2/10/2015.
 */
public class AsyncFillWords03 extends AsyncTask<Context, Void, String> {
    Context mCtx;

    public AsyncFillWords03(Context context) {
        mCtx = context;
    }

    @Override
    protected String doInBackground(Context... params) {
        FillTable.Words(mCtx, DbConstants.WordListFile03);
        return "true";
    }

    @Override
    protected void onPostExecute(String truefalse) {

    }
}