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
public class mascotas {
     private int id_mascotas;
     private String nombre; 
     private int nacimiento; 
     private especialidad e;
     private cliente c; 

    public mascotas(int id_mascotas, String nombre, int nacimiento, especialidad e, cliente c) {
        this.id_mascotas = id_mascotas;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.e = e;
        this.c = c;
    }

    public int getId_mascotas() {
        return id_mascotas;
    }

    public void setId_mascotas(int id_mascotas) {
        this.id_mascotas = id_mascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public especialidad getE() {
        return e;
    }

    public void setE(especialidad e) {
        this.e = e;
    }

    public cliente getC() {
        return c;
    }

    public void setC(cliente c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "mascotas{" + "id_mascotas=" + id_mascotas + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", e=" + e + ", c=" + c + '}';
    }

                
}
