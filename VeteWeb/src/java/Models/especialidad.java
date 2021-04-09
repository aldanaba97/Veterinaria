/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Aldana
 */
public class especialidad {
     private int id_especialidad; 
     private String descripcion;

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public especialidad(int id_especialidad, String descripcion) {
        this.id_especialidad = id_especialidad;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "especialidad{" + "id_especialidad=" + id_especialidad + ", descripcion=" + descripcion + '}';
    }
     
     
}
