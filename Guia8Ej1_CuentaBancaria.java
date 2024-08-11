/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia8ej1_cuentabancaria;

import Entidades.cuentaBancaria;
import Servicios.cuentaBancariaServicios;
import java.util.Scanner;

/**
 * Realizar una clase llamada CuentaBancaria en el paquete Entidades con los
 * siguientes atributos: numeroCuenta(entero), dniCliente(entero largo),
 * saldoActual. Agregar constructor vacío, con parámetros, getters y setters.
 * Agregar la clase CuentaBancariaServicio en el paquete Servicios que contenga:
 * a) Método para crear cuenta pidiéndole los datos al usuario. b) Método
 * ingresar(double): recibe una cantidad de dinero a ingresar y se le sumará al
 * saldo actual. c) Método retirar(double): recibe una cantidad de dinero a
 * retirar y se le restara al saldo actual. Si la cuenta no tiene la cantidad de
 * dinero a retirar se retirará el máximo posible hasta dejar la cuenta en 0. d)
 * Método extraccionRapida: le permitirá sacar solo un 20% de su saldo. Validar
 * que el usuario no saque más del 20%. e) Método consultarSaldo: permitirá
 * consultar el saldo disponible en la cuenta. f) Método consultarDatos:
 * permitirá mostrar todos los datos de la cuenta. 2
 *
 * @author usand
 */
public class Guia8Ej1_CuentaBancaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        cuentaBancariaServicios serv = new cuentaBancariaServicios();

        System.out.println("Crear cuenta bancaria");
        cuentaBancaria cuenta1 = serv.crearcuenta();
        
        int opc=0;
        
        do {
            

            System.out.println("\nMENU DE OPERACIONES:"
                    + "\n1-DEPOSITAR"
                    + "\n2-RETIRO"
                    + "\n3-EXTRACCION RAPIDA"
                    + "\n4-CONSULTAR SALDO"
                    + "\n5-CONSULTAR DATOS"
                    + "\n6-SALIR\n");
            opc = leer.nextInt();
            while (opc < 1 && opc > 5) {
                System.out.println("La opcion debe ser entre 1 y 6. Elegir de nuevo");
                opc = leer.nextInt();
            }

            switch (opc) {
                case 1:
                    serv.ingresar(cuenta1);
                    break;
                case 2:
                    serv.retirar(cuenta1);
                    break;
                case 3:
                    serv.extraccionRapida(cuenta1);
                    break;
                case 4:
                    serv.consultarSaldo(cuenta1);
                    break;
                case 5:
                    serv.consultarDatos(cuenta1);
                    break;
            }

        } while (opc != 6);
    }
}
