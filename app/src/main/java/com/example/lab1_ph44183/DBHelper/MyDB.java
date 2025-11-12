package com.example.lab1_ph44183.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QLSP.db";
    private static final int DATABASE_VERSION = 1;

    public MyDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCat = "CREATE TABLE \"Category\" (\n" +
                "  \"id_cat\" integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "  \"catname\" TEXT NOT NULL\n" +
                ");";
        db.execSQL(sqlCat);
        String sqlSP = "CREATE TABLE \"SanPham\" (\n" +
                "  \"id_sp\" integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "  \"tensp\" TEXT NOT NULL,\n" +
                "  \"giasp\" real NOT NULL,\n" +
                "  \"id_cat\" integer NOT NULL,\n" +
                "  CONSTRAINT \"id_cat\" FOREIGN KEY (\"id_cat\") REFERENCES \"Category\" (\"id_cat\")\n" +
                ");";
        db.execSQL(sqlSP);

        db.execSQL("INSERT INTO Category (catname) VALUES ('Điện thoại')");
        db.execSQL("INSERT INTO Category (catname) VALUES ('Laptop')");
        db.execSQL("INSERT INTO Category (catname) VALUES ('Phụ kiện')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SanPham");
        db.execSQL("DROP TABLE IF EXISTS Category");
        onCreate(db);
    }


}
