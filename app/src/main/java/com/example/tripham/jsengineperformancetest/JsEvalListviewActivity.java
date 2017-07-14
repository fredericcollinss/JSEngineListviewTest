package com.example.tripham.jsengineperformancetest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class JsEvalListviewActivity extends BaseListviewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        listview = (ListView) findViewById(R.id.listview);
        execTimers = new DuktapeFunctionCall(this);
        timeAdapter = new ExecTimeAdapter(this, execTimers);

        listview.setAdapter(timeAdapter);
    }
}
