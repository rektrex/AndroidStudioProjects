package com.example.toggletoast;

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
        ToggleButton tb = findViewById(R.id.toggleButton);
        tb.setTextOff("Silent");
        tb.setTextOn("Ringing");
    }

    public void clicked(View view) {
        ToggleButton tb = findViewById(R.id.toggleButton);
        ImageView iv = findViewById(R.id.imageView);
        if (tb.isChecked()) {
            iv.setImageResource(R.color.colorAccent);
        } else {
            iv.setImageResource(R.color.colorPrimary);
        }
        Toast.makeText(MainActivity.this, tb.getText(), Toast.LENGTH_LONG).show();
    }
}
