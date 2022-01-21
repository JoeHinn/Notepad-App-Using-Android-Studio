package com.example.notepadapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Notesdatabase extends SQLiteOpenHelper {
    public static final String Database_Name = "NotesDatabase.db";
    public static final String Table_Name = "Notes_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TOPIC";
    public static final String COL_3 = "NOTES";
    public Notesdatabase(@Nullable Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,TOPIC TEXT,NOTES TEXT) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }
    //To Insert the a row from the database table
    public boolean insertdata(String topic,String notes)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,topic);
        contentValues.put(COL_3,notes);
        long result = db.insert(Table_Name,null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    //To update a row from the database table
    public boolean updatedata(String id,String topic,String notes)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,topic);
        contentValues.put(COL_3,notes);
        db.update(Table_Name,contentValues,"ID = ?",new String[] {id});
        return true;
    }
    //To Delete the a row from the database table
    public Integer deletedata(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name, "ID = ?", new String[] {id});
    }
    public ArrayList<NotesDetails> getalldata()
    {
        ArrayList<NotesDetails> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor datas = db.rawQuery("SELECT * FROM Notes_Table",null);
        while (datas.moveToNext())
        {
            int id = datas.getInt(0);
            String topic = datas.getString(1);
            String notes = datas.getString(2);
            NotesDetails notesDetails = new NotesDetails(id,topic,notes);
            arrayList.add(notesDetails);
        }
        return arrayList;
    }


}
