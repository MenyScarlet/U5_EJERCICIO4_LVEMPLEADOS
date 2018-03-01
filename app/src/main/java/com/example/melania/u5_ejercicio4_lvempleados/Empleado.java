package com.example.melania.u5_ejercicio4_lvempleados;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Melania on 27/02/2018.
 */

public class Empleado implements Parcelable {

    String nombre;
    String dni;
    String profesion;

    //CREATOR
    public static final Parcelable.Creator<Empleado> CREATOR = new
            Parcelable.Creator<Empleado>() {
                public Empleado createFromParcel(Parcel in) {
                    return new Empleado(in);
                }
                public Empleado[] newArray(int size) {
                    return new Empleado[size];
                }
            };
    //FIN CREATOR

   //CONSTRUCTOR


    public Empleado() {
    }

    public Empleado(String nombre, String dni, String profesion) {
        this.nombre = nombre;
        this.dni = dni;
        this.profesion = profesion;
    }

    public Empleado(Parcel p) {
        readFromParcel(p);
    }

    //GETTERS AND SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.nombre);
        parcel.writeString(this.dni);
        parcel.writeString(this.profesion);

    }

    //Creamos un metodo readFromParcel que usaremos para llamarlo en el
//constructor parcelable
    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        this.dni = p.readString();
        this.profesion = p.readString();

    }
}
