package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    int[] arr = new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void here(View v)
{

    switch (v.getId()) {
        case R.id.c1:
            CheckBox c = findViewById(R.id.c1);
            if (c.isChecked()) {

                arr[0] = 1;

            }
            else
                arr[0]=0;


        case R.id.c2:
             CheckBox cq = findViewById(R.id.c2);
            if (cq.isChecked()) {

                arr[1]=1;

            }
            else
                arr[1]=0;

        case R.id.c3:
            CheckBox cw = findViewById(R.id.c3);
            if (cw.isChecked()) {

                arr[2]=1;

            }
            else arr[2]=0;
            break;
        case R.id.c4:
            CheckBox ce = findViewById(R.id.c4);
            if (ce.isChecked()) {

                arr[3]=1;

            }
            else
                arr[3]=0;
            break;
    }


    }

    public void li(View v)
    {
        Intent in=new Intent(MainActivity.this, fina.class);
        in.putExtra("val", arr);
        startActivity(in);
    }
}