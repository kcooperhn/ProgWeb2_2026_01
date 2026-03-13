package hn.uth.ejercicioprimefaces.data;

import java.io.Serializable;

public class Tarea implements Serializable {
    private String nombre;
    private String notas;
    private boolean completada;

    public Tarea() {
        this.completada = false;
        this.nombre="";
        this.notas="";
    }

    public Tarea(String nombre, String notas, boolean completada) {
        this.nombre = nombre;
        this.notas = notas;
        this.completada = completada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Tarea copiar() {
        return new Tarea(this.nombre, this.notas, this.completada);
    }
}
