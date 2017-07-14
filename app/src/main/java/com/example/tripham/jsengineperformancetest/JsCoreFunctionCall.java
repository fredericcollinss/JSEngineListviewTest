package com.example.tripham.jsengineperformancetest;

import android.content.Context;
import android.util.Log;

import org.liquidplayer.webkit.javascriptcore.JSContext;
import org.liquidplayer.webkit.javascriptcore.JSObject;

/**
 * Created by tripham on 7/14/17.
 */

public class JsCoreFunctionCall extends BaseFunctionCall {

    private JSContext jsContext;

    JsCoreFunctionCall(Context context) {
        super(context);

        jsContext = new JSContext();
        jsContext.evaluateScript(getBaseJs());
    }

    @Override
    public long execute() {
        final long startTime = System.nanoTime();
        jsContext.evaluateScript("getMax()");
        final long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
