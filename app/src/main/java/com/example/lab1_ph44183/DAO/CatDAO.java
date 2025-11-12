package com.example.lab1_ph44183.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab1_ph44183.DBHelper.MyDB;
import com.example.lab1_ph44183.Model.ModelCat;

import java.util.ArrayList;


public class CatDAO {
    private MyDB myDB;
    private SQLiteDatabase database;

    public CatDAO(Context context){
        myDB = new MyDB(context);
    }

    public void open(){
        database = myDB.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public long addCategory(ModelCat modelCat){
        ContentValues values = new ContentValues();
        values.put("catname", modelCat.getCatname());
        return database.insert("Category", null, values);
    }

    public ArrayList<ModelCat> getAll() {
        ArrayList<ModelCat> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Category", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                list.add(new ModelCat(id, name));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public ModelCat getCatById(int id) {
        Cursor cursor = database.rawQuery("SELECT * FROM Category WHERE id_cat = ?", new String[] {String.valueOf(id)});
        if (cursor.moveToFirst()) {
            ModelCat modelCat = new ModelCat(
                    cursor.getInt(0),
                    cursor.getString(1)
            );
            cursor.close();
            return modelCat;
        }
        cursor.close();
        return null;
    }
}
