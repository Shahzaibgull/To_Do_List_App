package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckedTextView;

public class Incomplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomplete);

        CheckedTextView t2;
        String data;

        t2=findViewById(R.id.checkedTextView2);
        Intent intent = getIntent();
        data = intent.getStringExtra("list");
        t2.setText(data);
    }
}