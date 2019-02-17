package com.example.foodordering;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] prices = {
                "10",
                "20",
                "5"
        };

        String[] items = {
                "Dairy Milk",
                "Kit Kat",
                "Perk"
        };

        ListView lv1 = findViewById(R.id.items);
        ListView lv2 = findViewById(R.id.price);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);
        ArrayAdapter<String> pricesAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, prices);

        lv1.setAdapter(itemsAdapter);
        lv2.setAdapter(pricesAdapter);

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
