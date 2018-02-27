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

    }//FIN onCreate

    public void clickInsertar (View view){


    }

    public void clickModificar (View view){


    }

}//FIN MainActivity
