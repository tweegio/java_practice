
package Ejercicios;

import Servicio.ArregloService;

public class G9ejercicio3 {

    public static void main(String[] args) {
        double[] arregloA = new double[50];
        double[] arregloB = new double[20];
        
        ArregloService servicio = new ArregloService();
        System.out.println("Inicializar arreglo A");
        servicio.inicializarA(arregloA);
        System.out.println("Mostrar arreglo A:");
        servicio.mostrar(arregloA);
        System.out.println("Ordenar arreglo A");
        servicio.ordenar(arregloA);
        System.out.println("Inicializar arreglo B");
        servicio.inicializarB(arregloA, arregloB);
        System.out.println("Mostrar arreglo A ordenado");
        servicio.mostrar(arregloA);
        System.out.println("Mostrar arreglo B");
        servicio.mostrar(arregloB);
    }

}
