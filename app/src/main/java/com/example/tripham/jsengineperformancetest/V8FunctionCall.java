package com.example.tripham.jsengineperformancetest;

import android.content.Context;

import com.eclipsesource.v8.V8;

/**
 * Created by tripham on 7/14/17.
 */

public class V8FunctionCall extends BaseFunctionCall {

    V8 mV8;
    Context context;

    V8FunctionCall(final Context context) {
        super(context);
        mV8 = init(context);
    }

    V8 init(Context context) {
        V8 v8 = V8.createV8Runtime();
        String baseJs = getBaseJs() + "; ";
        v8.executeScript(baseJs);
        return v8;
    }

    @Override
    public long execute() {
        final long startTime = System.nanoTime();
        mV8.executeScript("getMax()");
        final long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
