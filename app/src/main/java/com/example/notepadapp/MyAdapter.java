package com.example.notepadapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<NotesDetails> arrayList;

    public MyAdapter(Context context, ArrayList<NotesDetails> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
            convertView = inflater.inflate(R.layout.listviewfornotes,null);
            TextView note_id = (TextView)convertView.findViewById(R.id.idtxt);
            TextView note_topic = (TextView)convertView.findViewById(R.id.topictxt);
            TextView note_notes = (TextView)convertView.findViewById(R.id.notestxt);

            NotesDetails notesDetails = arrayList.get(position);
            note_id.setText(String.valueOf(notesDetails.getId()));
            note_topic.setText(notesDetails.getTopic());
            note_notes.setText(notesDetails.getNote());
        return convertView;
    }
}
