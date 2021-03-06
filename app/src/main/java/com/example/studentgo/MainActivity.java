package com.example.studentgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName33);
        e2 = (EditText) findViewById(R.id.editTextTextPersonName34);
        b1 = (Button) findViewById(R.id.button32);
        b2 = (Button) findViewById(R.id.button33);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Signup.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase sql = openOrCreateDatabase("akg", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists student (name varchar, email varchar, password varchar)");
                    String s4 = "select * from student where name = '"+s1+"' and email = '"+s2+"'";
                    Cursor c1 = sql.rawQuery(s4, null);
                    if(c1.getCount() > 0){
                        Toast.makeText(MainActivity.this, "Wrong Credentials!", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Homepage.class);
                        startActivity(i);
                        finish();

                    }
                }
            }
        });
    }
}