package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        TextView tv = findViewById(R.id.textView);
        Intent intent = getIntent();
        int x = intent.getIntExtra("val", 0);
        tv.setText("" + x);
    }
}
