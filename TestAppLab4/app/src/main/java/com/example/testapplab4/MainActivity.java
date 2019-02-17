package com.example.testapplab4;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        Toast toast = new Toast(MainActivity.this);
        ImageView imv = new ImageView(MainActivity.this);
        imv.setImageResource(R.drawable.sample_0);
        toast.setView(imv);
        toast.show();
    }

    public void toggleButtonClick(View view) {
        Toast toast = new Toast(MainActivity.this);
        ImageView imv = new ImageView(MainActivity.this);
        ToggleButton tb = findViewById(R.id.toggleButton);
        if (tb.isChecked()) {
            imv.setImageResource(R.drawable.sample_1);
        } else {
            imv.setImageResource(R.drawable.sample_2);
        }
        toast.setView(imv);
        toast.show();
    }
}