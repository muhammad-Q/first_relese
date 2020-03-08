package com.example.firstrelese.db_connection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hp;

    public DBHelper(Context context) {
        super ( context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL ( "create table contacts (id integer primary key, chatid text,w_group_name text,company_name  integer,driver_name  integer,driver_phone  integer,car_number integer,car_rental integer,price integer,costumes_decleration integer,bag_weight integer)" );
        db.execSQL ( "create table charge_dets (id integer primary key,company_name  text ,date Date,driver_name  text,driver_phone  text,car_number text,car_rental text,price text,costumes_decleration text,bag_weight text)" );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL ( "DROP TABLE IF EXISTS contacts" );
        onCreate ( db );
    }

    public boolean insertContact(String chatid, String w_group_name, int company_name, int driver_name, int driver_phone, int car_number, int car_rental, int bag_weight, int costumes_decleration, int price) {
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues ();
        contentValues.put ( "chatid", chatid );
        contentValues.put ( "w_group_name", w_group_name );
        contentValues.put ( "company_name", company_name );
        contentValues.put ( "driver_name", driver_name );
        contentValues.put ( "driver_phone", driver_phone );
        contentValues.put ( "car_number", car_number );
        contentValues.put ( "car_rental", car_rental );
        contentValues.put ( "price", price );
        contentValues.put ( "costumes_decleration", costumes_decleration );
        contentValues.put ( "bag_weight", bag_weight );
        db.insert ( "contacts", null, contentValues );
        return true;
    }

    public boolean insertcharge_dets(String company_name, Date date, String driver_name, String driver_phone, String car_number, int car_rental,int bag_weight, String costumes_decleration,int price) {
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues ();
        contentValues.put ( "date", String.valueOf ( date ) );

        contentValues.put ( "company_name", company_name );
        contentValues.put ( "driver_name", driver_name );
        contentValues.put ( "driver_phone", driver_phone );
        contentValues.put ( "car_number", car_number );
        contentValues.put ( "car_rental", car_rental );
        contentValues.put ( "price", price );
        contentValues.put ( "costumes_decleration", costumes_decleration );
        contentValues.put ( "bag_weight", bag_weight );
        db.insert ( "charge_dets", null, contentValues );
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor res = db.rawQuery ( "select * from contacts where id=" + id + "", null );
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase ();
        int numRows = (int) DatabaseUtils.queryNumEntries ( db, CONTACTS_TABLE_NAME );
        return numRows;
    }

    public boolean updateContact(int id, int company_name, int driver_name, int driver_phone, int car_number, int car_rental, int bag_weight, int costumes_decleration, int price) {
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues ();
        System.out.print ( company_name );
        contentValues.put ( "company_name", company_name );
        contentValues.put ( "driver_name", driver_name );
        contentValues.put ( "driver_phone", driver_phone );
        contentValues.put ( "car_number", car_number );
        contentValues.put ( "car_rental", car_rental );
        contentValues.put ( "price", price );
        contentValues.put ( "costumes_decleration", costumes_decleration );
        contentValues.put ( "bag_weight", bag_weight );
        db.update ( "contacts", contentValues, "id = ? ", new String[]{Integer.toString ( id )} );
        return true;
    }
    public boolean updateContact1(int id, String company_name, String driver_name, String driver_phone, String car_number, String car_rental, String bag_weight, String costumes_decleration, String price) {
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues ();
        System.out.print ( company_name );
        contentValues.put ( "company_name", company_name );
        contentValues.put ( "driver_name", driver_name );
        contentValues.put ( "driver_phone", driver_phone );
        contentValues.put ( "car_number", car_number );
        contentValues.put ( "car_rental", car_rental );
        contentValues.put ( "price", price );
        contentValues.put ( "costumes_decleration", costumes_decleration );
        contentValues.put ( "bag_weight", bag_weight );
        db.update ( "contacts", contentValues, "id = ? ", new String[]{Integer.toString ( id )} );
        return true;
    }

    public Integer deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase ();
        return db.delete ( "contacts",
                "id = ? ",
                new String[]{Integer.toString ( id )} );
    }

    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String> ();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor res = db.rawQuery ( "select * from contacts", null );
        res.moveToFirst ();

        while (res.isAfterLast () == false) {

            array_list.add ( res.getString ( res.getColumnIndex ( "w_group_name" ) ) );
            res.moveToNext ();
        }
        System.out.println ( array_list + "jjjjjjjjjjjjjjjjj" );
        return array_list;
    }

    public ArrayList<String> get_group(String name) {
        ArrayList<String> array_list = new ArrayList<String> ();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor res = db.rawQuery ( "SELECT * FROM contacts WHERE TRIM(w_group_name) = '" + name.trim () + "'", null );

        res.moveToFirst ();
        while (res.isAfterLast () == false) {
            array_list.add ( res.getString ( res.getColumnIndex ( "chatid" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "w_group_name" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "company_name" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "driver_name" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "driver_phone" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "car_number" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "car_rental" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "price" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "costumes_decleration" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "bag_weight" ) ) );
            array_list.add ( res.getString ( res.getColumnIndex ( "id" ) ) );
            res.moveToNext ();
        }
        System.out.println ( array_list + "jjjjjjjjjjjjjjjjj" );
        return array_list;
    }
}
