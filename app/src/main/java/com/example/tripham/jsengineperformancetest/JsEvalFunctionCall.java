package com.example.tripham.jsengineperformancetest;

import android.content.Context;

import com.evgenii.jsevaluator.JsEvaluator;

/**
 * Created by tripham on 7/14/17.
 */

public class JsEvalFunctionCall extends BaseFunctionCall {

    private final JsEvaluator mJsEvaluator;

    JsEvalFunctionCall(Context context) {
        super(context);
        mJsEvaluator = new JsEvaluator(context);
    }

    @Override
    public long execute() {
        // JS Evaluator executes every command in a separate context
        // so we have to load the full script on each iteration
        String js = getBaseJs()
                + ";";
        final long startTime = System.nanoTime();
        mJsEvaluator.evaluate("getMax()");
        final long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
