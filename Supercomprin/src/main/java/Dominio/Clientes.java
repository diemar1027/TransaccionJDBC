/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author diemar
 */
public class Clientes {
    private String Nombre;
    private String Apellidos;
    private String DNI;
    private Date FechaDeNacimiento;
    private String Email;
    private float Saldo_E_Wallet;
    private int Puntos_E_Wallet;

    public Clientes() {
    }
    

    public Clientes(String Nombre, String Apellidos, String DNI, Date FechaDeNacimiento, String Email, float Saldo_E_Wallet, int Puntos_E_Wallet) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.DNI = DNI;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.Email = Email;
        this.Saldo_E_Wallet = Saldo_E_Wallet;
        this.Puntos_E_Wallet = Puntos_E_Wallet;
    }

    @Override
    public String toString() {
        return "Clientes{" + "Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", DNI=" + DNI + ", FechaDeNacimiento=" + FechaDeNacimiento + ", Email=" + Email + ", Saldo_E_Wallet=" + Saldo_E_Wallet + ", Puntos_E_Wallet=" + Puntos_E_Wallet + '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public float getSaldo_E_Wallet() {
        return Saldo_E_Wallet;
    }

    public void setSaldo_E_Wallet(int Saldo_E_Wallet) {
        this.Saldo_E_Wallet = Saldo_E_Wallet;
    }

    public int getPuntos_E_Wallet() {
        return Puntos_E_Wallet;
    }

    public void setPuntos_E_Wallet(int Puntos_E_Wallet) {
        this.Puntos_E_Wallet = Puntos_E_Wallet;
    }
}
