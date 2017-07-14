package com.example.tripham.jsengineperformancetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find and wire up our buttons
        bind(findViewById(R.id.duktape_button), "duktape");
        bind(findViewById(R.id.jscore_button), "jscore");
        bind(findViewById(R.id.js_evaluator_button), "jseval");
        bind(findViewById(R.id.v8_button), "v8");
    }

    private void bind(View v, final String type) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(BaseListviewActivity.getCallingIntent(MainActivity.this, type));
            }
        });
    }
}
