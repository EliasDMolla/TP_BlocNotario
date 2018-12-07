package com.example.jmrr.tp_blocnotario.AD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by JMRR on 23/05/2018.
 */

public class ManejadorBD extends SQLiteOpenHelper {

    public ManejadorBD(Context context) {
        super(context, "BlocNotario.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Notas (" +
                "id_Nota INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Titulo TEXT, " +
                "Contenido TEXT, " +
                "Fecha TEXT," +
                "Activo BIT ) ";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Notas");
        onCreate (db);

    }

}