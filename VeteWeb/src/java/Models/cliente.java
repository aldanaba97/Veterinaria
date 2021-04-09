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
public class cliente {
    private String nombreCliente; 
    private String telefono; 
    private int id_cliente; 

    public cliente(String nombreCliente, String telefono, int id_cliente) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.id_cliente = id_cliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "cliente{" + "nombreCliente=" + nombreCliente + ", telefono=" + telefono + ", id_cliente=" + id_cliente + '}';
    }
        
}
