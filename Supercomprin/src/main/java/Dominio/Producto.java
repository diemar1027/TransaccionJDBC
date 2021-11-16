/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author diemar
 */
public class Producto {
    private int PrecioPuntos;
    private float Precio;
    private int Stock;
    private String Nombre;
    private String ID;

    public Producto() {
    }

    public Producto(int PrecioPuntos, float Precio, int Stock, String Nombre, String ID) {
        this.PrecioPuntos = PrecioPuntos;
        this.Precio = Precio;
        this.Stock = Stock;
        this.Nombre = Nombre;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Producto{" + "PrecioPuntos=" + PrecioPuntos + ", Precio=" + Precio + ", Stock=" + Stock + ", Nombre=" + Nombre + ", ID=" + ID + '}';
    }

    public int getPrecioPuntos() {
        return PrecioPuntos;
    }

    public void setPrecioPuntos(int PrecioPuntos) {
        this.PrecioPuntos = PrecioPuntos;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
