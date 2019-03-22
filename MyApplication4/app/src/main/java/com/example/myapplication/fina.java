package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fina extends AppCompatActivity {

int to=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fina);
        Intent in=getIntent();
        int[] arr = new int[4];

        arr=in.getIntArrayExtra("val");
        if(arr[0]==1){
            TextView t=findViewById(R.id.t1);
            t.setText("pizza");
            TextView p1=findViewById(R.id.p1);
            p1.setText("999");
            to+=999;
        }
        if(arr[1]==1){
            TextView t=findViewById(R.id.t2);
            t.setText("pasta");
            TextView p1=findViewById(R.id.p2);
            p1.setText("555");
            to+=555;
        }
        if(arr[2]==1){
            TextView t=findViewById(R.id.t3);
            t.setText("fries");
            TextView p1=findViewById(R.id.p3);
            p1.setText("299");
            to+=299;
        }
        if(arr[3]==1){
            TextView t=findViewById(R.id.t3);
            t.setText("ice tea");
            TextView p1=findViewById(R.id.p3);
            p1.setText("199");
            to+=199;
        }

        Button b=(Button)findViewById(R.id.b);


    }

    public void hi(View v)
    {
        Intent i=new Intent(fina.this, third.class);
        i.putExtra("val", to);
        startActivity(i);
    }
}
