package com.ameen.samplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyDBHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="products.db";
    public static final String TABLE_PRODUCTS="products";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_PRODUCTNAME="productsname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String query="CREATE TABLE " + TABLE_PRODUCTS + "(" +
               COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" +
               COLUMN_PRODUCTNAME + " " +
               ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCTS);
        onCreate(db);

    }
    public void addProduct(Products products)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_PRODUCTNAME,products.get_productsname());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();

    }
    public void deleteProdtuct(String productName)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " +TABLE_PRODUCTS+ "WHERE" +COLUMN_PRODUCTNAME+ "=\"" +productName+ "\";");
    }

    public String dataBaseTOstring(){
        String dbstring="";
        SQLiteDatabase db=getWritableDatabase();
        String query ="SELECT * FROM " +TABLE_PRODUCTS +" WHERE 1";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("productName"))!=null)
            {
                dbstring += c.getString(c.getColumnIndex("producyName"));
                dbstring += "\n";

            }
        }
        db.close();
        return dbstring;

    }

}
