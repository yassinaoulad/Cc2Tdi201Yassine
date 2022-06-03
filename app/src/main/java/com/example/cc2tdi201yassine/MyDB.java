package com.example.cc2tdi201yassine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
        cv.put(col2,s.getNom());
        cv.put(col3,s.getSecteur_activite());
        cv.put(col4,s.getNombre_employe());
        return sqLiteDatabase.insert(TABLE_NAME,null,cv);
    }

    public static long updateSociete(SQLiteDatabase sqLiteDatabase, Societe s){
        ContentValues cv = new ContentValues();
        cv.put(col2,s.getNom());
        cv.put(col3,s.getSecteur_activite());
        cv.put(col4,s.getNombre_employe());
        return sqLiteDatabase.update(TABLE_NAME,cv,"ID="+s.getID(),null);
    }

    public static long deleteSociete(SQLiteDatabase sqLiteDatabase, int id){
        return sqLiteDatabase.delete(TABLE_NAME,"ID="+id,null);
    }

    public static ArrayList<Societe> getAllSociete(SQLiteDatabase sqLiteDatabase){
        ArrayList<Societe> societes = new ArrayList<>();

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        while(cur.moveToNext()){
            Societe s = new Societe();
            s.setID(cur.getInt(0));
            s.setNom(cur.getString(1));
            s.setSecteur_activite(cur.getString(2));
            s.setNombre_employe(cur.getInt(3));
            societes.add(s);
        }

        return societes;
    }


    public static Societe getOneSociete(SQLiteDatabase sqLiteDatabase, int id){
        Societe s = null;

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id,null);

        if(cur.moveToNext()){
            s = new Societe();
            s.setID(cur.getInt(0));
            s.setNom(cur.getString(1));
            s.setSecteur_activite(cur.getString(2));
            s.setNombre_employe(cur.getInt(3));
        }

        return s;
    }




}
