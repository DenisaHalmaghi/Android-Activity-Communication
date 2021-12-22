package com.example.lucrarea5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String tag = "Lifecycle Step";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "In the onCreate() event");

        textView = findViewById(R.id.lifecycleTextView);

        textView.setText("onCreate "+getLifecycle().getCurrentState());

    }

    public void onStart()
    {
        super.onStart();
        Log.d(tag, "In the onStart() event");
        textView.setText("onStart "+getLifecycle().getCurrentState());
    }
    public void onRestart()
    {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
        textView.setText("onRestart "+getLifecycle().getCurrentState());
    }
    public void onResume()
    {
        super.onResume();
        Log.d(tag, "In the onResume() event");
        textView.setText("onResume "+getLifecycle().getCurrentState());
    }
    public void onPause()
    {
        super.onPause();
        Log.d(tag, "In the onPause() event");
        textView.setText("onPause "+getLifecycle().getCurrentState());
    }
    public void onStop()
    {
        super.onStop();
        Log.d(tag, "In the onStop() event");
        textView.setText("onStop "+getLifecycle().getCurrentState());
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
        textView.setText("onDestroy "+getLifecycle().getCurrentState());
    }
}