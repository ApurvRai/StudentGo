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

import com.google.android.gms.common.SignInButton;

public class SignIn extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        e1 = (EditText)findViewById(R.id.editTextTextPersonName30);
        e2 = (EditText)findViewById(R.id.editTextTextPersonName31);
        e3 = (EditText)findViewById(R.id.editTextTextPersonName32);
        b1 = (Button)findViewById(R.id.button30);
        b2 = (Button)findViewById(R.id.button31);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignIn.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals(""))
                {
                    Toast.makeText(SignIn.this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase sql = openOrCreateDatabase("akg", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists student (name varchar, email varchar, password varchar)");
                    String s4 = "select * from student where name = '"+s1+"' and email = '"+s2+"'";
                    Cursor c1 = sql.rawQuery(s4, null);
                    if(c1.getCount() > 0){
                        Toast.makeText(SignIn.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        sql.execSQL("insert into student values('"+s1+"', '"+s2+"', '"+s3+"')");
                        Toast.makeText(SignIn.this, "Account Created!", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(SignIn.this, MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}