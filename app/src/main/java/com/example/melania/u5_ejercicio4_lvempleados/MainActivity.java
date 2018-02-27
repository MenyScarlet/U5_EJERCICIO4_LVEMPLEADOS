package com.example.melania.u5_ejercicio4_lvempleados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_EMPLEADOS = "EXTRA_EMPLEADOS";
    ListView lvEmpleados;
    ArrayList<Empleado> lista_empleados = new ArrayList<Empleado>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();

        lvEmpleados = (ListView)findViewById(R.id.Main_LvEmpleados);

        AdaptadorEmpleados adaptadorEmpleados = new AdaptadorEmpleados(this,
                lista_empleados);

        lvEmpleados.setAdapter(adaptadorEmpleados);

        //Click corto = mostrar datos en la siguiente Activity
        lvEmpleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Empleado e =((Empleado)adapterView.getItemAtPosition(i));

                Intent intent = new Intent (getApplicationContext(),InfoListViewActivity.class);

                    intent.putExtra(EXTRA_EMPLEADOS, e);

                startActivity(intent);
            }
        });

        //Click largo = eliminar Empleado
        lvEmpleados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Empleado e =((Empleado)adapterView.getItemAtPosition(i));



                return true;
            }
        });

    }//FIN onCreate

    public void clickNuevoEmpleado (View view){

        Intent intent = new Intent(getApplicationContext(),InfoListViewActivity.class);
        startActivity(intent);

    }


    private void cargarDatos(){
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
        lista_empleados.add(new Empleado("", "", ""));
    }

}//FIN MainActivity
