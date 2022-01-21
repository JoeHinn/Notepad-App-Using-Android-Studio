package com.example.notepadapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.notepadapp.MainActivity.mydb;

public class NewNotePage extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note_page);
        overridePendingTransition(R.anim.mainfadein,R.anim.splashfadeout);
        Window window = NewNotePage.this.getWindow();
        getSupportActionBar().setTitle("New Note");

    }
    public void Savebutton(View view)
    {
        EditText Topic = findViewById(R.id.entertopic);
        EditText Notes = findViewById(R.id.enternotes);
        if (Topic.getText().toString().equals("") && Notes.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Sorry You have not Written any to Save",Toast.LENGTH_LONG).show();
        }
        else if(Topic.getText().toString().equals("") || Notes.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Sorry You have Missed Something to Write ( TOPIC OR NOTES )",Toast.LENGTH_LONG).show();
        }
        else
        {
            boolean Saved_or_Not = mydb.insertdata(Topic.getText().toString(),Notes.getText().toString());
            if (Saved_or_Not == true)
            {
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            else if(Saved_or_Not == false)
            {
                Toast.makeText(getApplicationContext(),"Sorry,Something is wrong",Toast.LENGTH_SHORT).show();
            }
        }
        }
    }
