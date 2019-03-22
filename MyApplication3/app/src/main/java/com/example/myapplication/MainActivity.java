package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton tb = findViewById(R.id.t1);
        tb.setTextOff("big dog");
        tb.setTextOn("dog");
    }

    public void high(View v) {
        ImageView iv = new ImageView(MainActivity.this);
        iv.setImageResource(R.drawable.sample_0);
        Toast t = new Toast(this);
        t.setView(iv);
        t.show();
    }
}
