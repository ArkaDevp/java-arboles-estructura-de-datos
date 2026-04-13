package escenario.cinco;

import java.util.Scanner;

/*
Nombres:
Santiago Posada Garcia
Angelo Acevedo Cano
Santiago Garcia Castañeda
*/
public class Main {

    /* En esta clase Main desarrollamos el ejercicio 4 y empleamos la clase VEDArbin

    4. Desarrolle una solución que permita la lectura de un arreglo de números enteros, este
    arreglo deberá ser ingresado por el usuario, tanto su tamaño como sus valores, de
    acuerdo al arreglo ingresado genere un árbol binario, posterior a esto deberá crear un
    metodo que reciba un valor el cual deberá ser ingresado por el usuario y el árbol binario,
    el metodo deberá retornar true si el número se encuentra dentro del árbol, o false si este
    no existe.*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Creacion del arbol desde un arreglo
        System.out.print("¿Cuántos números tendrá el arreglo?: ");
        int n = sc.nextInt();
        int[] arreglo = new int[n];

        VEDArbin<Integer> miArbol = new VEDArbin<>();

        System.out.println("Ingresa los " + n + " números:");
        for (int i = 0; i < n; i++) {
            arreglo[i] = sc.nextInt();
            // Usamos el metodo auxiliar para insertar con la logica de Ordenado
            miArbol = insertarOrdenado(miArbol, arreglo[i]);
        }

        // 2. Ejecutamos el metodo para encontrar la cantidad de nodos (solicitado en el punto 3)
        System.out.println("Cantidad de nodos: " + miArbol.cantidadNodos());

        // 3. Solicitamos el numero que el usuario quiere buscar en el arbol
        System.out.print("Ingresa el número a buscar: ");
        int buscado = sc.nextInt();

        /* Llamamos al metodo buscar con el numero ingresado por el usuario y el arbol creado,
         lo guardamos en una variable y posteriormente lo imprimimos*/
        boolean existe = buscar(miArbol, buscado);
        System.out.println("¿El número existe en el árbol?: " + existe);

    }




    // Lógica de búsqueda basada en la inspección de nodos
    public static boolean buscar(VEDArbin<Integer> a, int valor) {
        if (a.esVacio()) {
            return false; // El árbol vacío no tiene elementos
        }
        if (a.val.equals(valor)) {
            return true; // Encontrado en la raíz
        }
        // Buscar recursivamente en subárboles
        return buscar(a.izq, valor) || buscar(a.der, valor);
    }

    /* Este es un metodo auxiliar creado para insertar valores al arbol y realizar la logica de Ordenado,
     si este numero es menor, ira a la izquierda de su padre, si es mayor, ira a la derecha.
     Recibe el nodo y su respectivo valor a a insertar */
    public static VEDArbin<Integer> insertarOrdenado(VEDArbin<Integer> a, int valor) {
        if (a.esVacio()) {
            // Si el nodo es vacio, creamos uno nuevo con hijos vacios
            return new VEDArbin<>(valor, new VEDArbin<>(), new VEDArbin<>());
        }
        // Menores a la izquierda, mayores a la derecha
        if (valor < a.val) {
            a.izq = insertarOrdenado(a.izq, valor);
        } else if (valor > a.val) {
            a.der = insertarOrdenado(a.der, valor);
        }
        return a;
    }
}
