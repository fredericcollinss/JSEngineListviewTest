package com.example.tripham.jsengineperformancetest;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tripham on 7/14/17.
 */

public abstract class BaseFunctionCall {

    private static final String JS_FILEPATH = "JavascriptTest.js"; // TODO add the actual js file here

    private final Context mContext;
    private final String mBaseJs;

    BaseFunctionCall(Context context) {
        mContext = context;
        mBaseJs = loadJs();
        Log.i("BaseFUnctionCall", "BaseFunctionCall loaded " + mBaseJs);
    }

    private String loadJs() {
        String js = null;
        try {
            InputStream open = mContext.getAssets().open(JS_FILEPATH);
            js = IoUtils.readInputStream(open);
        } catch (IOException e) {
            Log.e("BaseGrader", e.getLocalizedMessage());
        }
        return js;
    }

    String getBaseJs() {
        return mBaseJs;
    }

    public abstract long execute();
}
