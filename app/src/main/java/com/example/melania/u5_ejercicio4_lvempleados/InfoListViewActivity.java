package com.example.melania.u5_ejercicio4_lvempleados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoListViewActivity extends AppCompatActivity {

    EditText etNombre, etDni, etProfesion;
    Button btnInsertar, btnModificar;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

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
            etNombre.setText(e.getNombre());
            etDni.setText(e.getDni());
            etProfesion.setText(e.getProfesion());
            etDni.setEnabled(false);
            btnInsertar.setEnabled(false);

        }else{

            btnModificar.setEnabled(false);

        }

    }//FIN onCreate

    public void clickInsertar (View view){

        String nombre = etNombre.getText().toString();
        String dni = etDni.getText().toString();
        String profesion = etProfesion.getText().toString();

        if(nombre.equals("") || dni.equals("") || profesion.equals("")){

            Toast.makeText(getApplicationContext(), "Debes de rellenar todos los campos",
                    Toast.LENGTH_LONG).show();

        }else {

            Empleado nuevoEmpleado = new Empleado(nombre, dni, profesion);
            dbRef = FirebaseDatabase.getInstance().getReference().child("Empleados");

        /*String nueva_clave = dbRef().push().setvalue(nuevoEmpleado, new DatabaseReference.
        CompletionListener(){*/

            /*cambiar el contenido del parentesis(dni) segun el id que le quieras dar tu
            se lo puedes dar tu directamente metiendolo entre " " o que coga como id el dato
            que quieras que ya tenga el objeto por ejemplo el (dni)*/
            dbRef.child(dni).setValue(nuevoEmpleado, new DatabaseReference.CompletionListener() {

                public void onComplete(DatabaseError error, DatabaseReference ref) {

                    if (error == null) {

                        Toast.makeText(getApplicationContext(), "INSERTADO CORRECTAMENTE",
                                Toast.LENGTH_LONG).show();

                        limpiarFormulario();

                    } else {

                        Toast.makeText(getApplicationContext(), "NO SE PUEDE INSERTAR EL Empleado",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }



    }

    public void clickModificar (View view){

        String nombre = etNombre.getText().toString();
        String dni = etDni.getText().toString();
        String profesion = etProfesion.getText().toString();


        if(nombre.equals("") || dni.equals("") || profesion.equals("")){

            Toast.makeText(getApplicationContext(), "Debes de rellenar todos los campos",
                    Toast.LENGTH_LONG).show();

        }else {

            Empleado nuevoEmpleado = new Empleado(nombre, dni, profesion);
            dbRef = FirebaseDatabase.getInstance().getReference().child("Empleados");

            /*Esto es solo para modificar un elemento del firebase*/
            String idSeleccionado = etDni.getText().toString();

            /*String nueva_clave = dbRef().push().setvalue(nuevoEmpleado, new DatabaseReference.
        CompletionListener(){*/
            dbRef.child(idSeleccionado).setValue(nuevoEmpleado, new DatabaseReference.CompletionListener() {

                public void onComplete(DatabaseError error, DatabaseReference ref) {

                    if (error == null) {

                        Toast.makeText(getApplicationContext(),
                                "MODIFICADO CORRECTAMENTE",
                                Toast.LENGTH_LONG).show();

                        limpiarFormulario();

                    } else {

                        Toast.makeText(getApplicationContext(),
                                "NO SE PUEDE MODIFICADO EL EMPLEADO",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    private void limpiarFormulario (){

        etNombre.setText("");
        etDni.setText("");
        etProfesion.setText("");

    }

}//FIN MainActivity
