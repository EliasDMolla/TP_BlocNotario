package com.example.jmrr.tp_blocnotario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jmrr.tp_blocnotario.AD.NotasAD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity2NuevaNota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_nueva_nota);


    }

    public void BtnGuardar_Click(View view) {



        EditText txtTitulo= findViewById(R.id.txtTitulo);
        EditText txtContenido = findViewById(R.id.txtContenido);
        EditText txtFecha = findViewById(R.id.txtFecha);

        Date fecha =new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        txtFecha.setText(df.format(fecha));

        NotasAD.InsertarNota( this,txtTitulo.getText().toString(),txtContenido.getText().toString(),txtFecha.getText().toString());


        Toast.makeText(this, "Nota guardada correctamente", Toast.LENGTH_SHORT).show();

        Intent I = new Intent(this,MainActivity.class);
        startActivity(I);

    }
    public  void VolverMenu(View view){
        Intent I = new Intent(this,MainActivity.class);
        startActivity(I);
    }
}
