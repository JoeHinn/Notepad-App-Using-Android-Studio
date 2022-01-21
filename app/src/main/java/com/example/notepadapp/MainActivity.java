package com.example.notepadapp;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    public static Notesdatabase mydb;
    ListView list;
    ArrayList<NotesDetails> arrayList;
    MyAdapter myAdapter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Notes");
        Window window = MainActivity.this.getWindow();
        overridePendingTransition(R.anim.mainfadein,R.anim.splashfadeout);
        mydb = new Notesdatabase(this);
        list = (ListView)findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        loaddatainlistview();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.idtxt);
                TextView topicTextView = (TextView) view.findViewById(R.id.topictxt);
                TextView notesTextView = (TextView) view.findViewById(R.id.notestxt);
                String id = idTextView.getText().toString();
                String topic = topicTextView.getText().toString();
                String notes = notesTextView.getText().toString();
                Intent upanddelpage = new Intent(getApplicationContext(),EditandDelete.class);
                upanddelpage.putExtra("id",id);
                upanddelpage.putExtra("topic",topic);
                upanddelpage.putExtra("notes",notes);
                startActivity(upanddelpage);
            }
        });
    }
    public void onStart()
    {
        super.onStart();
        loaddatainlistview();
    }
    public void loaddatainlistview()
    {
        arrayList = mydb.getalldata();
        myAdapter = new MyAdapter(this,arrayList);
        list.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
    public void newnotebutton(View view)
    {
        Intent a = new Intent(getApplicationContext(),NewNotePage.class);
        startActivity(a);
    }
}