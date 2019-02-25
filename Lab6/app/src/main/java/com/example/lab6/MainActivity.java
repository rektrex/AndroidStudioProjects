package com.example.lab6;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.q1, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.courses:
                showCourses();
                return true;
            case R.id.admission:
                showAdmission();
                return true;
            case R.id.faculty:
                showFaculty();
                return true;

                default:
                    return true;
        }
    }

    protected void resetView() {
        TextView c1 = findViewById(R.id.textView5);
        TextView c2 = findViewById(R.id.textView6);
        TextView a1 = findViewById(R.id.textView7);
        LinearLayout fl1 = findViewById(R.id.linearLayout3);
        LinearLayout fl2 = findViewById(R.id.linearLayout4);

        c1.setVisibility(View.GONE);
        c2.setVisibility(View.GONE);
        a1.setVisibility(View.GONE);
        fl1.setVisibility(View.GONE);
        fl2.setVisibility(View.GONE);
    }

    protected void showCourses() {
        resetView();
        TextView c1 = findViewById(R.id.textView5);
        TextView c2 = findViewById(R.id.textView6);
        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
    }

    protected void showAdmission() {
        resetView();
        TextView a1 = findViewById(R.id.textView7);
        a1.setVisibility(View.VISIBLE);
    }

    protected void showFaculty() {
        resetView();
        LinearLayout fl1 = findViewById(R.id.linearLayout3);
        LinearLayout fl2 = findViewById(R.id.linearLayout4);
        fl1.setVisibility(View.VISIBLE);
        fl2.setVisibility(View.VISIBLE);
    }
}
