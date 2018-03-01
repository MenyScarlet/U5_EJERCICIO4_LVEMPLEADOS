package com.example.melania.u5_ejercicio4_lvempleados;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_EMPLEADOS = "EXTRA_EMPLEADOS";
    ListView lvEmpleados;


    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ArrayList<Empleado> lista_empleados = new ArrayList<Empleado>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatosFirebase();

        lvEmpleados = (ListView)findViewById(R.id.Main_LvEmpleados);








    }//FIN onCreate

    public void clickNuevoEmpleado (View view){

        Intent intent = new Intent(getApplicationContext(),InfoListViewActivity.class);
        startActivity(intent);

    }

    private void cargarDatosFirebase(){

        dbRef = FirebaseDatabase.getInstance().getReference().child("Empleados");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista_empleados.clear();//Importante para la carga de datos en TIEMPO REAL
                //Quita la antigua lista para cargar una nueva
                for (DataSnapshot empleadosDataSnapshot: dataSnapshot.getChildren()){
                    cargarListView(empleadosDataSnapshot);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("MainActivity","DATABASE ERROR");

            }
        };
        dbRef.addValueEventListener(valueEventListener);//Cargar datos en TIEMPO REAL
    }

    private void cargarListView (DataSnapshot dataSnapshot){



        lista_empleados.add(dataSnapshot.getValue(Empleado.class));

        final AdaptadorEmpleados adaptadorEmpleados = new AdaptadorEmpleados(this,
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

                dbRef = FirebaseDatabase.getInstance().getReference()
                        .child("Empleados");
                //cogemos el "dni" del objeto "e" con (e.getDni()).remove....
                Empleado e =((Empleado)adapterView.getItemAtPosition(i));
                dbRef.child(e.getDni()).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                        if (databaseError == null){


                            Toast.makeText(getApplicationContext(),
                                    "ELIMINADO CORRECTAMENTE",
                                    Toast.LENGTH_LONG).show();


                        }else{

                            Toast.makeText(getApplicationContext(),
                                    "NO SE PUEDE ELIMINAR EL JUGADOR",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                });

                /*Empleado e =((Empleado)adapterView.getItemAtPosition(i));

                lista_empleados.remove(i);
                adaptadorEmpleados.notifyDataSetChanged();*/


                return true;
            }

            /*public void dialogConfirmacion (View view){
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogConfirmacion dialogo = new DialogConfirmacion();
                dialogo.show(fragmentManager, "dialogConfirmacion");
            }*/


        });


    }


}//FIN MainActivity
