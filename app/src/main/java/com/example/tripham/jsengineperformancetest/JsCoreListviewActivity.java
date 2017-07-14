package com.example.tripham.jsengineperformancetest;

import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by tripham on 7/14/17.
 */

public class JsCoreListviewActivity extends BaseListviewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        listview = (ListView) findViewById(R.id.listview);
        execTimers = new JsCoreFunctionCall(this);
        timeAdapter = new ExecTimeAdapter(this, execTimers);

        listview.setAdapter(timeAdapter);
    }

}
