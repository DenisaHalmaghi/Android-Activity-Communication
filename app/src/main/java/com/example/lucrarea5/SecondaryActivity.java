package com.example.lucrarea5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        //sync data between activities
        EditText syncTextView = findViewById(R.id.secondarySyncTextView);
        Button button = findViewById(R.id.secondarySyncButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String message = extras.getString("message");
            syncTextView.setText(message);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String text = syncTextView.getText().toString();
                intent.putExtra("message_return", text );
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}