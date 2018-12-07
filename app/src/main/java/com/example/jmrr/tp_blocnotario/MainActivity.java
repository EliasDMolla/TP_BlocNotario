package com.example.jmrr.tp_blocnotario;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmrr.tp_blocnotario.AD.NotasAD;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();

        /*
        TextView lbl = (TextView) findViewById(R.id.LblNotas);
        Cursor cursor = NotasAD.BuscarTodaslasNotas(this);

        String Nota = "";
        if (cursor.moveToFirst()) {
            do {
                Nota = Nota + cursor.getString(0) + "-" +
                        cursor.getString(1) + "\n" +
                        cursor.getString(2) + "\n" +
                        cursor.getString(3) +  "\n";
            } while (cursor.moveToNext());
        }
        cursor.close();
       lbl.setText(Nota);
       */

        // Levanto la List View de Notas
        ListView lvNotas = (ListView) findViewById(R.id.lvNotas);

        // Busco todas las Notas de la Base de Datos en un Cursor
        Cursor cursor = NotasAD.BuscarTodaslasNotas(this);

        // Columnas de la Base de Datos en un Array de String
        String[] columnas = new String[] { "_id", "Titulo","Contenido","Fecha" };

        // Campos del Layout del Item para asignar los campos anteriores EN ORDEN
        int[] escribirEn = new int[] { R.id.li_idNota, R.id.li_Titulo, R.id.li_Contenido, R.id.li_Fecha};

        // Creo el Cursor Adapter para asignar al Layout
        SimpleCursorAdapter sca = new SimpleCursorAdapter(
                this,
                R.layout.list_item_nota,
                cursor,
                columnas,
                escribirEn,
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER

        );

        // Asigno el Adapter a la ListView
        lvNotas.setAdapter(sca);

        // Creo el Evento Click del Item de la ListView para hacer una acción
        lvNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Cualquier acción
                Toast.makeText(MainActivity.this, "Posicion: " + i + " - id: " + l,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void BtnNuevaNota_Click(View view) {

        Intent intento = new Intent(this, Activity2NuevaNota.class);
        startActivity(intento);

    }
    public void EliminarNotas(View view) {

        Intent intento = new Intent(this, activity_eliminar_notas.class);
        startActivity(intento);

    }
}
