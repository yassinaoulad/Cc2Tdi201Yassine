package com.example.cc2tdi201yassine;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {
    public static String dbName="dbSociete.db";
    public static String TABLE_NAME="societe";
    public static String col1="ID";
    public static String col2="Raison_Sociale";
    public static String col3="Secteur_activite";
    public static String col4="nb_employe";

    public MyDB(Context context){super(context,dbName,null,1);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "(" +col1+" integer primary key autoincrement,"+col2+" TEXT,"+col3+" TEXT,"+col4+" integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public static long addSociete(SQLiteDatabase sqLiteDatabase, Societe s){
        ContentValues cv = new ContentValues();
        cv.put(col1,s.getID());
        cv.put(col2,s.getNom());
        cv.put(col3,s.getSecteur_activite());
        cv.put(col4,s.getNombre_employe());
        return sqLiteDatabase.insert(TABLE_NAME,null,cv);
    }




}
