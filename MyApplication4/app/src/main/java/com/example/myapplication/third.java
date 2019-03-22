package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent in =new Intent();
        int c;
        c= in.getIntExtra("val", 1);
        TextView r=findViewById(R.id.t);
        r.setText(c+" ");


    }
}
