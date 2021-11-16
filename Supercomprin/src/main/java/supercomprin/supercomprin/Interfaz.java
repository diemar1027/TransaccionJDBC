/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercomprin.supercomprin;

import Datos.ClienteDAO;
import java.util.Scanner;
import Dominio.Clientes;
import Dominio.Producto;
import java.sql.Date;

/**
 *
 * @author diemar
 */
public class Interfaz {

    static Scanner teclado = new Scanner(System.in);
    static ClienteDAO clienteDAO = new ClienteDAO();
    static Clientes cliente = null;

    static Producto[] listaProductos = new Producto[6];

    public static void main(String[] args) {
        listaProductos[0] = new Producto(260, 0.65f, 5, "Quesito RICO 6Uds", "1");
        listaProductos[1] = new Producto(400, 1.00f, 5, "Bacon FRITO 8 Lonchas", "2");
        listaProductos[2] = new Producto(160, 0.40f, 5, "Pan MaderaDePan 1 Barra", "3");
        listaProductos[3] = new Producto(1200, 3.00f, 5, "Aceite Virgen OlivaExtra 1L", "4");
        listaProductos[4] = new Producto(800, 2.00f, 5, "Jamón Serrano PREMIUM 300g", "5");
        listaProductos[5] = new Producto(620, 1.55f, 5, "Docena de Huevos GALLINA", "6");

        /**
         * Variables del método
         */
        boolean funciona = true;
        int opcionTeclado = 0;
        /**
         * Visual del menú de elección con las opciones que queramos aplicar
         * para Propietario y Coche //1. Mostrar // propietarios y sus coches
         * //2. Insertar //3. Borrar //4. Actualizar //0. Salir
         */
        while (funciona) {
            switch (opcionTeclado) {
                /**
                 * Impresión del menú con las posibles elecciones en su
                 * funcionamiento
                 */
                case 0:
                    System.out.println("// **** MENU PRINCIPAL **** //");
                    System.out.println("1. Opciones Cliente");
                    System.out.println("2. Comprar producto");
                    System.out.println("3. Devolver producto");
                    System.out.println("\n0. Salir");
                    System.out.println("------------------------------");
                    opcionTeclado = pedirOpcion();
                    System.out.println("==============================\n\n");
                    if (opcionTeclado == 0) {
                        funciona = false;
                    }

                    break;
                /**
                 * Generación de un menú para seleccionar que mostrar al usuario
                 */
                case 1:
                    System.out.println("// **** OPCIONES CLIENTE **** //");

                    System.out.println("1. Crear Cliente");
                    System.out.println("2. Iniciar Sesión");
                    System.out.println("3. Ver información del Cliente");
                    System.out.println("4. Añadir Saldo");
                    System.out.println("5. Volver al Menú Principal");
                    int opcionInsertar = pedirOpcion();
                    System.out.println("-----------------------");
                    switch (opcionInsertar) {
                        case 1:
                            System.out.println("Nombre:");
                            String Nombre = teclado.nextLine();
                            System.out.println("Apellidos: ");
                            String Apellidos = teclado.nextLine();
                            System.out.println("DNI: ");
                            String DNI = teclado.nextLine();

                            System.out.println("Día de Nacimiento: ");
                            int DiaDeNacimiento = teclado.nextInt();

                            System.out.println("Mes de nacimiento: ");
                            int MesDeNacimiento = teclado.nextInt();

                            System.out.println("Año de nacimiento: ");
                            int AnyoDeNacimiento = teclado.nextInt();
                            teclado.nextLine();
                            Date FechaDeNacimiento = new Date(AnyoDeNacimiento - 1900, MesDeNacimiento, DiaDeNacimiento);

                            System.out.println("Email: ");
                            String Email = teclado.nextLine();

                            float Saldo_E_Wallet = 0;
                            int Puntos_E_Wallet = 0;

                            cliente = clienteDAO.insertar(Nombre, Apellidos, DNI, FechaDeNacimiento, Email, Saldo_E_Wallet, Puntos_E_Wallet);//Crear y añadir el propietario
                            break;
                        case 2:
                            System.out.println("**** Iniciar Sesión ****");
                            System.out.println("**** Introduce tu DNI para cotinuar: ");
                            String DNIiniciar = teclado.nextLine();
                            cliente = clienteDAO.IniciarSesion(DNIiniciar);
                            opcionTeclado = 0;
                            break;
                        case 3:
                            if (cliente != null) {
                                System.out.println("Nombre: " + cliente.getNombre());
                                System.out.println("Apellidos: " + cliente.getApellidos());
                                System.out.println("DNI: " + cliente.getDNI());
                                System.out.println("Fecha de nacimiento: " + cliente.getFechaDeNacimiento());
                                System.out.println("Email: " + cliente.getEmail());
                                System.out.println("Saldo: " + cliente.getSaldo_E_Wallet());
                                System.out.println("Puntos: " + cliente.getPuntos_E_Wallet());
                                opcionTeclado = 0;
                            } else {
                                System.out.println("No se ha creado un usuario\n");
                            }
                            break;
                        case 4:
                            System.out.println("// **** Añadir dinero **** //");
                            System.out.println("Introduzca la cantidad de dinero que desea sumar: ");
                            float dineri = teclado.nextFloat();
                            teclado.nextLine();

                            //Multiplico el dinero a introducir por -1 para que en lugar de restar el 
                            //saldo se sume y asi ahorrarme una consulta nueva
                            clienteDAO.actualizar(-1 * dineri, 0, cliente.getDNI());
                            cliente = clienteDAO.IniciarSesion(cliente.getDNI());

                            break;
                        case 5:
                            opcionTeclado = 0;
                            break;
                    }
                    System.out.println("=======================\n");
                    opcionTeclado = 0;
                    break;
                /**
                 * Generación de un menú para insertar propietarios o coches a
                 * elección del usuario
                 */

                case 2:
                    if (cliente != null) {
                        System.out.println("// **** Comprar producto **** //");
                        System.out.println("1. Ver y Comprar Productos");
                        System.out.println("2. Volver al Menú Principal");

                        int opcionComprar = pedirOpcion();
                        System.out.println("-------------------------");
                        switch (opcionComprar) {
                            case 1:
                                System.out.println("Productos");
                                /**
                                 * Aquí iría la lista de productos junto la
                                 * compra de ewallet for(){
                                 * System.out.println("1. producto"); }
                                 * System.out.println("ELije el numero de
                                 * prod"); switch(){ cliente.actualizar(saldo,
                                 * puntos); }
                                 */

                                for (int i = 0; i < listaProductos.length; i++) {
                                    System.out.println(listaProductos[i].getID() + " | " + listaProductos[i].getNombre() + " | " + listaProductos[i].getPrecio() + "€ | " + listaProductos[i].getPrecioPuntos() + "Pts");
                                }

                                int opcionCompra = pedirOpcion();

                                System.out.println("Comprar " + listaProductos[opcionCompra - 1].getNombre() + " por " + listaProductos[opcionCompra - 1].getNombre() + "€ (s/n)?");
                                boolean comprar = teclado.nextLine().charAt(0) == 's' ? true : false;

                                if (comprar) {
                                    if (cliente.getSaldo_E_Wallet() - listaProductos[opcionCompra - 1].getPrecio() < 0) {
                                        System.out.println("No tienes suficiente dinero (" + cliente.getSaldo_E_Wallet() + ")");
                                        opcionTeclado = 0;
                                    } else {
                                        clienteDAO.actualizar(listaProductos[opcionCompra - 1].getPrecio(), listaProductos[opcionCompra - 1].getPrecioPuntos(), cliente.getDNI());
                                        cliente = clienteDAO.IniciarSesion(cliente.getDNI());
                                        System.out.println("*** " + listaProductos[opcionCompra - 1].getNombre() + " | saldo actual: " + cliente.getSaldo_E_Wallet() + " ***");
                                    }
                                    opcionTeclado = 0;
                                } else {
                                    opcionTeclado = 0;
                                }

                                break;
                            case 2:
                                opcionTeclado = 0;
                                break;
                        }

                        System.out.println("=======================\n");
                    } else {
                        System.out.println("No se ha creado un usuario\n");
                    }
                    opcionTeclado = 0;
                    break;
                /**
                 * Generación de un menú para borrar propietarios o coches u
                 * propietarios con sus respectivos coches
                 */
                case 3:
                    if (cliente != null) {
                        System.out.println("// **** Devolver Producto **** //");
                        System.out.println("1. Elige que productos quieres devolver");

                        for (int i = 0; i < listaProductos.length; i++) {
                            System.out.println(listaProductos[i].getID() + " | " + listaProductos[i].getNombre() + " | " + listaProductos[i].getPrecio() + "€ | " + listaProductos[i].getPrecioPuntos() + "Pts");
                        }

                        int opcionDevolver = pedirOpcion();
                        System.out.println("---------------------");

                        System.out.println("Devolver " + listaProductos[opcionDevolver - 1].getNombre() +"(s/n)?");
                        boolean devolver = teclado.nextLine().charAt(0) == 's' ? true : false;

                        if (devolver) {
                            if (cliente.getPuntos_E_Wallet()- listaProductos[opcionDevolver - 1].getPrecioPuntos()< 5) {
                                System.out.println("No puedes, te quedarias con menos de 5 puntos");
                                opcionTeclado = 0;
                            } else {
                                clienteDAO.actualizar(-1 * listaProductos[opcionDevolver - 1].getPrecio(), -1 * listaProductos[opcionDevolver - 1].getPrecioPuntos(), cliente.getDNI());
                                cliente = clienteDAO.IniciarSesion(cliente.getDNI());
                                System.out.println("*** Saldo actual: " + cliente.getSaldo_E_Wallet() + " | Puntos actuales: " + cliente.getPuntos_E_Wallet() + "Pts ***");
                            }
                            opcionTeclado = 0;
                        } else {
                            opcionTeclado = 0;
                        }

                    } else {
                        System.out.println("No se ha creado un usuario\n");
                    }
                    opcionTeclado = 0;
            }
        }
    }

    /**
     * Función que pide al usuario un número del menú para ejecutarlo
     *
     * @return devuelve el número introducido por el usuario
     */
    private static int pedirOpcion() {
        System.out.println("Opción: ");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        return opcion;
    }
}
