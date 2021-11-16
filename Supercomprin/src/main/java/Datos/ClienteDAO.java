/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import static Datos.Conexion.close;
import static Datos.Conexion.getConnection;
import Dominio.Clientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diemar
 */
public class ClienteDAO {

    private static String SQL_INSERT = "INSERT INTO clientes VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static String SQL_SELECT = "SELECT * FROM clientes WHERE DNI = ?";
    private static String SQL_UPDATE_COMPRA = "UPDATE clientes SET Saldo_E_Wallet = Saldo_E_Wallet - ?, Puntos_E_Wallet = Puntos_E_Wallet + ? WHERE DNI = ?";

    public static Clientes insertar(String Nombre, String Apellidos, String DNI, Date FechaDeNacimiento, String Email, float Saldo_E_Wallet, int Puntos_E_Wallet) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;
        Clientes cliente = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Nombre);
            stmt.setString(2, Apellidos);
            stmt.setString(3, DNI);
            stmt.setDate(4, FechaDeNacimiento);
            stmt.setString(5, Email);
            stmt.setFloat(6, Saldo_E_Wallet);
            stmt.setInt(7, Puntos_E_Wallet);

            resultado = stmt.executeUpdate();
            cliente = new Clientes(Nombre, Apellidos, DNI, FechaDeNacimiento, Email, Saldo_E_Wallet, Puntos_E_Wallet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return cliente;
    }

    public Clientes IniciarSesion(String DNIUsuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;
        int registros = 0;
        try {
            conn = getConnection();

            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, DNIUsuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String DNI = rs.getString("DNI");
                String Nombre = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                Date FechaDeNacimiento = rs.getDate("FechaDeNacimiento");
                String Email = rs.getString("Email");
                float Saldo_E_Wallet = rs.getFloat("Saldo_E_Wallet");
                int Puntos_E_Wallet = rs.getInt("Puntos_E_Wallet");

                cliente = new Clientes(Nombre, Apellidos, DNI, FechaDeNacimiento, Email, Saldo_E_Wallet, Puntos_E_Wallet);
            }

        } catch (SQLException ex) {
            //ex.printStackTrace(System.out);
            System.out.println(ex.getMessage());
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return cliente;
    }

    public static int actualizar(float precio, int puntos, String DNI) {
        /**
         * Variables:
         */
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        /**
         * Se envia la sentencia SQL En el catch genera un mensaje en caso de
         * error Y en el finally cierra las variables
         */
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_COMPRA);

            stmt.setFloat(1, precio);
            stmt.setInt(2, puntos);
            stmt.setString(3, DNI);

            resultado = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
            }
        }

        return resultado;
    }

}
