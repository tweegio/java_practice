package Servicio;

import java.util.Arrays;

/*
Método inicializarA recibe un arreglo por parámetro y lo inicializa con números aleatorios.
*/
public class ArregloService {

    public void inicializarA(double[] arregloA) {
        for (int i = 0; i < arregloA.length; i++) {
            arregloA[i] = Math.random() * 11;
        }
    }

    public void mostrar(double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" [" + arreglo[i] + "] ");
        }
        System.out.println("");
    }

    public void ordenar(double[] arreglo) {
        Arrays.sort(arreglo);
        double[] copiaArreglo = arreglo;
        for (int i = 0; i < copiaArreglo.length / 2; i++) { // Va de las puntas al medio para ordenarlos
            double aux = copiaArreglo[i];
            copiaArreglo[i] = copiaArreglo[copiaArreglo.length - 1 - i];
            copiaArreglo[copiaArreglo.length - 1 - i] = aux;
        }
        
    }

    public void inicializarB(double[] arregloA, double[] arregloB) {
        System.arraycopy(arregloA, 0, arregloB, 0, 10);
        Arrays.fill(arregloB, 10, arregloB.length, 0.5);
    }
    
    
    
}
