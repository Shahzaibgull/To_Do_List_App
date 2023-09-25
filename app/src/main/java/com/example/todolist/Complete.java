package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckedTextView;

import androidx.appcompat.app.AppCompatActivity;

public class Complete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        CheckedTextView t1;
        String data;

        t1=findViewById(R.id.checkedTextView);
        Intent intent = getIntent();
        data = intent.getStringExtra("list");
        t1.setText(data);


    }
}