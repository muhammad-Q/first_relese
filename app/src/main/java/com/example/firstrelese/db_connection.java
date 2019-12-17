package com.example.firstrelese;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class db_connection extends SQLiteOpenHelper {
    public static final String dbname="information.db";
    public static final int  version =2;
    @RequiresApi(api = Build.VERSION_CODES.P)
    public db_connection(Context context) {
        super(context,dbname,null,version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  IF NOT EXISTS subject (id INTEGER NOT NULL PRIMARY KEY,name TEXT ,nick_name,group_id  Integer ,group_name )");
    }
public void test (SQLiteDatabase db)
{
   db.execSQL("CREATE TABLE  IF NOT EXISTS drag (id INTEGER NOT NULL PRIMARY KEY,name TEXT ,price INTEGER,price2 INTEGER )");

}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table IF EXISTS drag");
onCreate(db);
    }
    public void insert(String name,String nick_name ,String  group_name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        test(db);
        ContentValues cont=new ContentValues();
        cont.put("name",name);
        cont.put("nick_name",nick_name);
        cont.put("group_id", group_name);
        db.insert("subject",null,cont);

    }
    public ArrayList print()
    {    ArrayList a=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
    test( db);
        Cursor cur=db.rawQuery("SELECT * from subject",null);
cur.moveToFirst();
while(cur.isAfterLast()==false)
{
//    a.add(cur.getString(cur.getColumnIndex("name")));
    a.add(cur.getString(cur.getColumnIndex("name"))+" : "+cur.getString(cur.getColumnIndex("nick_name"))+" : "+cur.getString(cur.getColumnIndex("group_id")));
    cur.moveToNext();

}
return a;
    }
    public void delete(int id )

    {

        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("delete  from information where id="+Integer.toString(id));

    }
    public void edit(int id,String name )
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("update information set name='"+name +"' where id="+Integer.toString(id));
    }
}
