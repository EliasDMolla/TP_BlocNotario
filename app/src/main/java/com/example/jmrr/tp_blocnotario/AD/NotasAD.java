package com.example.jmrr.tp_blocnotario.AD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by JMRR on 23/05/2018.
 */

public class NotasAD {

    public static void InsertarNota(Context contexto, String Titulo, String Contenido, String Fecha)
    {
        ManejadorBD manejadorBD = new ManejadorBD(contexto);
        SQLiteDatabase db = manejadorBD.getWritableDatabase();

        db.execSQL("INSERT INTO Notas(Titulo, Contenido, Fecha, Activo) VALUES ('"   +
                Titulo +  "', '" + Contenido+ "', '" + Fecha+ "', 1)");
    }

    public static Cursor BuscarTodaslasNotas(Context contexto){
        ManejadorBD manejadorBD = new ManejadorBD(contexto);
        SQLiteDatabase db = manejadorBD.getReadableDatabase();

        return db.rawQuery("SELECT id_Nota _id, Titulo, Contenido, Fecha FROM Notas where Activo = 1", null);
    }
    public static void EliminarNota(Context contexto, Integer id_Nota)
    {
        ManejadorBD manejadorBD = new ManejadorBD(contexto);
        SQLiteDatabase db = manejadorBD.getWritableDatabase();

        db.execSQL("Update Notas set Activo=0 where id_Nota= '"+ id_Nota + "'");
    }


}
