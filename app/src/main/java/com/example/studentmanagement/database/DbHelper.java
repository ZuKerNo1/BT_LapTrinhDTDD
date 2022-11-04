package com.example.studentmanagement.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context,"QLSinhVien2", null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate = "CREATE TABLE IF NOT EXISTS " +
                " SinhVien(MaSV INTEGER PRIMARY KEY AUTOINCREMENT," +
                "HoTen VARCHAR(200)," +
                "GioiTinh INTEGER," +
                "DienThoai VARCHAR(13)," +
                "Email VARCHAR(50))";
        sqLiteDatabase.execSQL(sqlSVCreate);

        String sqlInsertSV = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) " +
                " values ('Lê Hoàng Anh Tuấn','1','0156982648','tuanle@gmail.com')," +
                        "('Thanh Thủy','2','05562641521','thuythanh@gmail.com')," +
                        "('Ánh Hồng','2','0956852554','ahong@gmail.com')" ;
        sqLiteDatabase.execSQL(sqlInsertSV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
