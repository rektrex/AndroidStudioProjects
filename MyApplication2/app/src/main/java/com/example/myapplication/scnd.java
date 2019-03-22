package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class scnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scnd);
        int c2;
        Intent in=getIntent();
        c2 = in.getIntExtra("val", 1);
        ConstraintLayout c= findViewById(R.id.cl2);
        switch (c2){
        case 1:
            c.setBackgroundColor(Color.RED);
            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
            break;
        case 2:
            c.setBackgroundColor(Color.BLUE);
            break;
        case 3:
            c.setBackgroundColor(Color.GREEN);
            break;
    }}
}
