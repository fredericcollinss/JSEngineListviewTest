package com.example.tripham.jsengineperformancetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class V8ListviewActivity extends BaseListviewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        listview = (ListView) findViewById(R.id.listview);
        execTimers = new V8FunctionCall(this);
        timeAdapter = new ExecTimeAdapter(this, execTimers);

        listview.setAdapter(timeAdapter);
    }
}
