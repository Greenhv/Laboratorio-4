package com.example.labtel.laboratorio4;

import com.orm.SugarRecord;

/**
 * Created by herbert on 10/23/16.
 */

public class Task extends SugarRecord {
    private String titulo;
    private String fechaInicio;
    private String fechaFin;
    private String listaTareas;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(String listaTareas) {
        this.listaTareas = listaTareas;
    }

    public Task(){
    }

    public Task(String titulo, String fechaI, String fechaF, String listaT) {
        setTitulo(titulo);
        setFechaInicio(fechaI);
        setFechaFin(fechaF);
        setListaTareas(listaT);
    }
}
