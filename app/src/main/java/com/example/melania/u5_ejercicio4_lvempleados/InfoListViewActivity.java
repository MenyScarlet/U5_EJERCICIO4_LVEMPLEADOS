package com.example.melania.u5_ejercicio4_lvempleados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InfoListViewActivity extends AppCompatActivity {

    EditText etNombre, etDni, etProfesion;
    Button btnInsertar, btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list_view);

        etNombre = (EditText)findViewById(R.id.Info_EtNombre);
        etDni = (EditText)findViewById(R.id.Info_EtDni);
        etProfesion = (EditText)findViewById(R.id.Info_EtProfesion);
        btnInsertar = (Button) findViewById(R.id.Info_BtnInsertar);
        btnModificar = (Button) findViewById(R.id.Info_BtnModificar);

        Bundle b = getIntent().getExtras();
        if (b != null){

            Empleado e = b.getParcelable(MainActivity.EXTRA_EMPLEADOS);
            etNombre.setText("Nombre: " + e.getNombre());
            etDni.setText("DNI: " + e.getDni());
            etProfesion.setText("Profesión: " + e.getProfesion());

        }

    }//FIN onCreate

    public void clickInsertar (View view){

        String nombre = etNombre.getText().toString();
        String dni = etDni.getText().toString();
        String profesion = etProfesion.getText().toString();



    }

    public void clickModificar (View view){

        String nombre = etNombre.getText().toString();
        String dni = etDni.getText().toString();
        String profesion = etProfesion.getText().toString();


    }

}//FIN MainActivity
