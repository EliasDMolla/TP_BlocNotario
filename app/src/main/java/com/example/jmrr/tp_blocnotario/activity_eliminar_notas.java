package com.example.jmrr.tp_blocnotario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jmrr.tp_blocnotario.AD.NotasAD;

public class activity_eliminar_notas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_notas);

    }
    public void VolverMenu(View view) {
        Intent I = new Intent(this, MainActivity.class);
        startActivity(I);
    }
    public void EliminarNotas(View view){
        EditText txtEliminar = findViewById(R.id.txtEliminar);
        Integer texto = Integer.parseInt(txtEliminar.getText().toString());
        NotasAD.EliminarNota(this,texto);
        Toast.makeText(this,"Eliminaste correctamente",Toast.LENGTH_LONG).show();

        Intent I = new Intent(this, MainActivity.class);
        startActivity(I);

    }
}
