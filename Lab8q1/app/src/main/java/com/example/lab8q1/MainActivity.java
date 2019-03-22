package com.example.lab8q1;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = openOrCreateDatabase("lab8q1.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists students(id integer, name varchar, branch varchar);");
        populateView();
    }

    public void populateView() {
        SQLiteDatabase db =  openOrCreateDatabase("lab8q1.db", MODE_PRIVATE, null);
        Cursor rs = db.rawQuery("select * from students", null);
        rs.moveToFirst();
        int count = rs.getCount();
        if (count == 0) {
            return;
        }
        final Integer[] ID = new Integer[count];
        final String[] name = new String[count];
        final String[] branch = new String[count];

        for (int i = 0; i < count; i++) {
            ID[i] = rs.getInt(0);
            name[i] = rs.getString(1);
            branch[i] = rs.getString(2);
            rs.moveToNext();
        }

        for (int i = 0; i < count; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (ID[j] < ID[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp = ID[i];
            ID[i] = ID[smallestIndex];
            ID[smallestIndex] = temp;

            String tempName = name[i];
            name[i] = name[smallestIndex];
            name[smallestIndex] = tempName;

            String tempBranch = branch[i];
            branch[i] = branch[smallestIndex];
            branch[smallestIndex] = tempBranch;
        }

        ArrayAdapter<Integer> IDAdapter = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_list_item_1, ID);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(IDAdapter);
        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LayoutInflater inflater = getLayoutInflater();
                final View v = inflater.inflate(R.layout.student_layout, null);
                EditText etid = v.findViewById(R.id.editText2);
                EditText etname = v.findViewById(R.id.editText3);
                EditText etbranch = v.findViewById(R.id.editText4);

                etid.setText("" + ID[position]);
                etname.setText(name[position]);
                etbranch.setText(branch[position]);

                etid.setEnabled(false);
                etname.setEnabled(false);
                etbranch.setEnabled(false);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Student information")
                        .setView(v)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                populateView();
                            }
                        })
                        .show();
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getTitle().toString().equals("delete")) {
            int rowId = (int)info.id;
            ListView lv = findViewById(R.id.lv);
            int id = (Integer) lv.getItemAtPosition(rowId);
            deleteStudent(id);
        } else {
            int rowId = (int) info.id;
            ListView lv = findViewById(R.id.lv);
            int id = (Integer) lv.getItemAtPosition(rowId);
            updateStudent(id);
        }
        populateView();
        return true;
    }

    public void addStudent(View view) {
        final LayoutInflater inflater = getLayoutInflater();
        final View v = inflater.inflate(R.layout.student_layout, null);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Add student")
                .setView(v)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etid = v.findViewById(R.id.editText2);
                        EditText etname = v.findViewById(R.id.editText3);
                        EditText etbranch = v.findViewById(R.id.editText4);

                        int id = Integer.parseInt(etid.getText().toString());
                        String name = etname.getText().toString();
                        String branch = etbranch.getText().toString();

                        SQLiteDatabase db = openOrCreateDatabase("lab8q1.db", MODE_PRIVATE, null);
                        db.execSQL("insert into students(id, name, branch) values(" + id + ", '" + name + "', '" + branch + "')");
                        populateView();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    public void deleteStudent(int id) {
        SQLiteDatabase db = openOrCreateDatabase("lab8q1.db", MODE_PRIVATE, null);
        db.execSQL("delete from students where id = " + id);
    }

    public void updateStudent(final int id) {
        SQLiteDatabase db = openOrCreateDatabase("lab8q1.db", MODE_PRIVATE, null);
        final LayoutInflater inflater = getLayoutInflater();
        final View v = inflater.inflate(R.layout.student_layout, null);

        final EditText etid = v.findViewById(R.id.editText2);
        etid.setText("" + id);
        etid.setEnabled(false);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Add student")
                .setView(v)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etname = v.findViewById(R.id.editText3);
                        EditText etbranch = v.findViewById(R.id.editText4);

                        String name = etname.getText().toString();
                        String branch = etbranch.getText().toString();

                        SQLiteDatabase db = openOrCreateDatabase("lab8q1.db", MODE_PRIVATE, null);
                        db.execSQL("update students " +
                                    "set name ='" + name + "', " +
                                    "branch = '" + branch + "' " +
                                    "where id = " + id);
                        populateView();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
