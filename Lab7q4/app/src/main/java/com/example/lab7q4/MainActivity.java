package com.example.lab7q4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()) {
            case "Keywords":
                final LayoutInflater inflater = getLayoutInflater();
                final View v = inflater.inflate(R.layout.search_dialog, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Search")
                        .setView(v)
                        .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText et = v.findViewById(R.id.editText);
                                highlightSearch(et.getText().toString());
                            }
                        })
                        .show();
                break;
            case "Sort":
                TextView tv = findViewById(R.id.textView);
                String[] txt = tv.getText().toString().split(" ");
                Arrays.sort(txt);
                String res = "";
                for (String el : txt) {
                    res += el;
                    res += " ";
                }
                tv.setText(res);
                break;
        }
        return true;
    }

    public void highlightSearch(String searchTerm) {
        final TextView tv = findViewById(R.id.textView);
        String[] words = tv.getText().toString().split(" ");
        int count = 0;
        for (String w : words) {
            if (w.equals(searchTerm)) {
                count++;
            }
        }
        if (count == 0) {
            Toast.makeText(MainActivity.this, "No matches found", Toast.LENGTH_SHORT).show();
        } else {
            String highlight = "<font color=#ff0000>" + searchTerm + "</font>";
            String txt = tv.getText().toString();
            String newtxt = txt.replaceAll(searchTerm, highlight);
            tv.setText(Html.fromHtml(newtxt));
            Toast.makeText(MainActivity.this, count + " matches found", Toast.LENGTH_SHORT).show();
        }
    }
}
