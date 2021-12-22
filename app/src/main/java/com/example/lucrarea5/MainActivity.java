package com.example.lucrarea5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        //pass data between activities
        EditText syncTextView = findViewById(R.id.syncTextView);
        Button button = findViewById(R.id.syncButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                String mytext = syncTextView.getText().toString();
                intent.putExtra("message", mytext);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);
        switch (requestCode) {
            case 1: EditText syncTextView = findViewById(R.id.syncTextView);
                if (resultCode == RESULT_OK) {
                    String messageReturn = dataIntent.getStringExtra("message_return");
                    syncTextView.setText(messageReturn);
                }
        }
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

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            EditText syncTextView = findViewById(R.id.syncTextView);
//            String message = extras.getString("message_return");
//            syncTextView.setText(message);
//            //The key argument here must match that used in the other activity
//        }
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