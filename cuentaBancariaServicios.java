/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.cuentaBancaria;
import java.text.DecimalFormat;
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
public class cuentaBancariaServicios {

    Scanner leer = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.00");

    public cuentaBancaria crearcuenta() {

        System.out.print("Ingresar numero de cuenta:   ");
        int numeroCuenta = leer.nextInt();

        System.out.print("Ingresar DNI del Cliente:   ");
        long dniCliente = leer.nextLong();

        System.out.print("Ingresar saldo inicial: $ ");
        double saldoActual = leer.nextDouble();

        return new cuentaBancaria(numeroCuenta, dniCliente, saldoActual);

    }

    public void ingresar(cuentaBancaria cu) {
        System.out.print("\nCuanto dinero va a ingresar?: $ ");
        double deposito = leer.nextDouble();

        cu.setSaldoActual(cu.getSaldoActual() + deposito);
        System.out.println("El saldo es de $ "+((cu.getSaldoActual()*100))/100);
    }

    public void retirar(cuentaBancaria cu) {
        System.out.print("\nIngresar monto a retirar: $ ");
        double retiro = leer.nextDouble();
        if (cu.getSaldoActual() < retiro) {
            System.out.println("El saldo es menor que el pedido de retiro"
                    + "\nSe entregara el saldo total: $ " + ((cu.getSaldoActual()*100))/100);
            cu.setSaldoActual(0);
           System.out.println("El saldo es de $ "+((cu.getSaldoActual()*100))/100);

        } else {
            System.out.println("El retiro de $ " + retiro + " fue exitoso");
            cu.setSaldoActual(cu.getSaldoActual() - retiro);
           System.out.println("El saldo es de $ "+((cu.getSaldoActual()*100))/100);
        }

    }

    public void extraccionRapida(cuentaBancaria cu) {

        double retiro = 1;
        do {
            System.out.print("\nIngresar monto a retirar: $ ");
            retiro = leer.nextDouble();
            if (cu.getSaldoActual() * 0.2 < retiro) {
                System.out.println("El retiro rapido entrega un maximo de $ "
                        +df.format(cu.getSaldoActual()*0.2) + "\nIngrese monto a retirar,"
                        + " o si quiere salir de retiro rapido presione cero(0)");
                System.out.printf("%.3f", cu.getSaldoActual()*0.2);

               

            } else {
                System.out.println("\nEl retiro de $ " + retiro + " fue exitoso");
                cu.setSaldoActual(cu.getSaldoActual() - retiro);
                System.out.println("El saldo es de $ "+((cu.getSaldoActual()*100))/100);
                break;
            }

        } while (retiro != 0);

    }

    public void consultarSaldo(cuentaBancaria cu) {
        System.out.println("\nEl saldo es de $ "+((cu.getSaldoActual()*100))/100);
    }

    public void consultarDatos(cuentaBancaria cu) {
        System.out.println("\nNumero de cuenta: " + cu.getNumeroCuenta());
        System.out.println("DNI del cliente: " + cu.getDniCliente());
        System.out.println("El saldo es de $ "+((cu.getSaldoActual()*100))/100);
    }

}
