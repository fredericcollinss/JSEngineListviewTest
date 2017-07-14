package com.example.tripham.jsengineperformancetest;

import android.os.Bundle;
import android.widget.ListView;

public class DuktapeListviewActivity extends BaseListviewActivity{

    private static final String TAG = DuktapeListviewActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        listview = (ListView) findViewById(R.id.listview);
        execTimers = new DuktapeFunctionCall(this);
        timeAdapter = new ExecTimeAdapter(this, execTimers);

        listview.setAdapter(timeAdapter);

        //Log.e(TAG, "null ")
    }
}
