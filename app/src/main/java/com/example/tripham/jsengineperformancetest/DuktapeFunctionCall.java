package com.example.tripham.jsengineperformancetest;

import android.content.Context;
import android.util.Log;

import com.squareup.duktape.Duktape;

/**
 * Created by tripham on 7/14/17.
 */

public class DuktapeFunctionCall extends BaseFunctionCall {
    private Duktape mDuktape;

    private static final String TAG = DuktapeFunctionCall.class.getName();

    DuktapeFunctionCall(final Context context) {
        super(context);
        mDuktape = init();
    }

    Duktape init() {
        Duktape duktape = Duktape.create();
        duktape.evaluate(getBaseJs() + ";");
        return duktape;
    }

    @Override
    public long execute() {
        final long startTime = System.nanoTime();
        mDuktape.evaluate("getMax()");
        final long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
