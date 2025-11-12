package com.example.lab1_ph44183.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab1_ph44183.DBHelper.MyDB;
import com.example.lab1_ph44183.Model.ModelSP;

import java.util.ArrayList;

public class SPDAO {
    MyDB myDB;
    private SQLiteDatabase database;

    public SPDAO(Context context) {
        myDB = new MyDB(context);
    }

    public void open(){
        database = myDB.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public long addSP(ModelSP modelSP){
        ContentValues values = new ContentValues();
        values.put("tensp", modelSP.getTensp());
        values.put("giasp", modelSP.getGiasp());
        values.put("id_cat", modelSP.getId_cat());
        return database.insert("SanPham", null, values);
    }

    public ArrayList<ModelSP> getAllSP() {
        ArrayList<ModelSP> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM SanPham", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String ten = cursor.getString(1);
                double gia = cursor.getDouble(2);
                int id_cat = cursor.getInt(3);
                list.add(new ModelSP(id, ten, gia, id_cat));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public ModelSP getSPById(int id) {
        Cursor cursor = database.rawQuery("SELECT * FROM SanPham WHERE id_sp = ?", new String[] {String.valueOf(id)});

        if (cursor.moveToFirst()) {
            ModelSP modelSP = new ModelSP(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getInt(3)
            );
            cursor.close();
            return modelSP;
        }
        cursor.close();
        return null;
    }
}
