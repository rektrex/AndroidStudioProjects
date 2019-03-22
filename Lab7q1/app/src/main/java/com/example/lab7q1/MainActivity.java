package com.example.lab7q1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] details = { "abc", "abd", "abe", "bab", "abb" };

        ListView lv = findViewById(R.id.lv);

        ArrayAdapter<String> detAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, details);
        lv.setAdapter(detAdapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                p.inflate(R.menu.context_menu);
                p.show();

                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                return true;
            }
        });
    }
}
