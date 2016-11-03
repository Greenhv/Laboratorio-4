package com.example.labtel.laboratorio4;

import com.orm.SugarRecord;

/**
 * Created by labtel on 22/10/2016.
 */

public class Contacto extends SugarRecord {
    private String nombre;
    private String DNI;
    private String correo;
    private String numero;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Contacto() {
    }

    public Contacto(String nombre, String dni, String correo, String numero ) {
        setNombre(nombre);
        setDNI(dni);
        setCorreo(correo);
        setNumero(numero);
    }
}
