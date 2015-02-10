package com.HishaTech.android.rearrange.db;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.HishaTech.android.rearrange.R;

/**
 * Created by smithkev on 2/10/2015.
 */
public class AsyncFillWords04 extends AsyncTask<Context, Void, String> {
    Context mCtx;

    public AsyncFillWords04(Context context) {
        mCtx = context;
    }

    @Override
    protected String doInBackground(Context... params) {
        FillTable.Words(mCtx, DbConstants.WordListFile04);
        return "true";
    }

    @Override
    protected void onPostExecute(String truefalse) {
        Toast.makeText(mCtx, R.string.toast_update_words,
                Toast.LENGTH_SHORT).show();
    }
}