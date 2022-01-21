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

public class EditandDelete extends AppCompatActivity {
    EditText topictext;
    EditText notestext;
    String id;
    String topic;
    String notes;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_editand_delete);
        getSupportActionBar().setTitle("Edit Note");
        Window window = EditandDelete.this.getWindow();
        id = intent.getStringExtra("id");
        topic = intent.getStringExtra("topic");
        notes = intent.getStringExtra("notes");
        topictext = (EditText)findViewById(R.id.enter_topic);
        notestext = (EditText)findViewById(R.id.enter_notes);
        topictext.setText(topic);
        notestext.setText(notes);
    }
    public void Saveupdatebutton(View view)
    {
        boolean updatenotes = mydb.updatedata(id,topictext.getText().toString(),notestext.getText().toString());
        if(updatenotes == true){
            Toast.makeText(getApplicationContext(),"Notes Updated",Toast.LENGTH_LONG).show();
            Intent main = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(main);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Sorry Something went Wrong",Toast.LENGTH_LONG).show();
        }
    }
    public void deletebutton(View view)
    {
        Integer deletedornoted = mydb.deletedata(id);
        if(deletedornoted > 0)
        {
            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
            Intent main = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(main);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }

}