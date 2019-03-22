package com.example.myapplication;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void here(View v)
    {
        int c = 1;
        switch (v.getId()) {
            case R.id.b1:
                c = 1;
                break;
            case R.id.b2:
                c = 2;
                break;
            case R.id.b3:
                c = 3;
                break;
        }
        Intent in=new Intent(MainActivity.this, scnd.class);
        in.putExtra("val", c);
        startActivity(in);
    }
}
