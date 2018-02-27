package com.example.melania.u5_ejercicio4_lvempleados;

/**
 * Created by Melania on 27/02/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdaptadorEmpleados extends ArrayAdapter<Empleado> {
    ArrayList<Empleado> empleados;
    Context c;
    public AdaptadorEmpleados(Context c, ArrayList<Empleado> empleados) {
        super(c, R.layout.item_empleado, empleados);
        this.empleados = empleados;
        this.c = c;
    }
    public View getView(int position, View view, ViewGroup
            viewGroup) {
        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_empleado, null);

        TextView tv_Nombre = (TextView)
                item.findViewById(R.id.Item_LvNombre);
        tv_Nombre.setText(empleados.get(position).getNombre() );

        TextView tv_Dni = (TextView)
                item.findViewById(R.id.Item_LvDni);
        tv_Dni.setText(empleados.get(position).getDni() );

        TextView tv_Profesion = (TextView)
                item.findViewById(R.id.Item_LvProfesion);
        tv_Profesion.setText(empleados.get(position).getProfesion() );

        return item;
    }
}
