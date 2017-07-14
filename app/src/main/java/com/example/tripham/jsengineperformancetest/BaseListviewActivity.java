package com.example.tripham.jsengineperformancetest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

public class BaseListviewActivity extends AppCompatActivity {
    public static Intent getCallingIntent(Context context, String type) {
        Intent intent = new Intent(context, BaseListviewActivity.class);
        intent.putExtra("type", type);
        return intent;
    }

    public static final String TAG = "Benchmark";

    protected ListView listView;

    protected ExecTimeAdapter timeAdapter;

    protected BaseFunctionCall execTimers;  // js engine to be assigned in sub classes

    protected ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_listview);
        listview = (ListView) findViewById(R.id.listview);

        Log.d(TAG, "Initializing...");
        String type = getIntent().getExtras().getString("type");
        switch (type) {
            case "duktape":
                execTimers = new DuktapeFunctionCall(this);
                break;
            case "jscore":
                execTimers = new JsCoreFunctionCall(this);
                break;
            case "jseval":
                execTimers = new JsEvalFunctionCall(this);
                break;
            case "v8":
                execTimers = new V8FunctionCall(this);
                break;
            default:
                throw new UnsupportedOperationException("Invalid type: " + type);
        }

        timeAdapter = new ExecTimeAdapter(this, execTimers);
        listview.setAdapter(timeAdapter);

        Log.d(TAG, "Start rendering...");
    }


    // An extends version of ArrayAdapter
    protected class ExecTimeAdapter extends BaseAdapter {

        private final Context context;
        private BaseFunctionCall functionCall;

        ExecTimeAdapter(Context context, BaseFunctionCall functionCall) {
            this.context = context;
            this.functionCall = functionCall;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view = convertView;
            if (view == null) {
                view = new TextView(context);
            }
            TextView txtView = (TextView) view;
            txtView.setText(String.format(Locale.US, "Took %s ms", functionCall.execute() / 1000000));
            return view;
        }
    }
}
