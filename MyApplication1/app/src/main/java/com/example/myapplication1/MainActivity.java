package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int val = 0;
    char op = '=';
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public int compute(char op, int x, int y) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
                default:
                    return y;
        }
    }

    public void btClick(View v) {
        TextView tv = findViewById(R.id.editText);
        switch (v.getId()) {
            case R.id.plus:
                val = compute(op, val, Integer.parseInt(tv.getText().toString()));
                op = '+';
                tv.setText("");
                break;
            case R.id.min:
                val = compute(op, val, Integer.parseInt(tv.getText().toString()));
                op = '-';
                tv.setText("");
                break;
            case R.id.div:
                val = compute(op, val, Integer.parseInt(tv.getText().toString()));
                op = '/';
                tv.setText("");
                break;
            case R.id.mul:
                val = compute(op, val, Integer.parseInt(tv.getText().toString()));
                op = '*';
                tv.setText("");
                break;
            case R.id.eq:
                val = compute(op, val, Integer.parseInt(tv.getText().toString()));
//                Toast.makeText(this, "" + val, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ResultPage.class);
                intent.putExtra("val", val);
                startActivity(intent);
                break;

                default:
                    Button bt = findViewById(v.getId());
                    tv.setText(tv.getText() + bt.getText().toString());
        }

    }
}
