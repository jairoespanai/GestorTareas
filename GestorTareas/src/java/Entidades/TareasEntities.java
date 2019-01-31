/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author lenovo
 */
public class TareasEntities {

    private int id;
    private String nombre;
    private String descripcion;
    private int estado;
    private String inicio;
    private String fin;
    private String responsable;

    public TareasEntities(String nombre, String descripcion, int estado, String inicio, String fin, String responsable) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.inicio = inicio;
        this.fin = fin;
        this.responsable = responsable;
    }

    public TareasEntities() {
        this.nombre = "";
        this.descripcion = "";
        this.estado = 0;
        this.inicio = "";
        this.fin = "";
        this.responsable = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

}
