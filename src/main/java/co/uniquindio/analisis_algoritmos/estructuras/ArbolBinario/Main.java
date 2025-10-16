package co.uniquindio.analisis_algoritmos.estructuras.ArbolBinario;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertarNodo(50);
        arbol.insertarNodo(30);
        arbol.insertarNodo(70);
        arbol.insertarNodo(20);
        arbol.insertarNodo(40);
        arbol.insertarNodo(60);
        arbol.insertarNodo(80);

        System.out.println("Recorrido Inorden:");
        arbol.imprimirInorder(arbol.getRaiz());
        System.out.println("\nAltura del árbol: " + arbol.altura());
        System.out.println("Cantidad de nodos: " + arbol.cantidadNodos());
        System.out.println("Peso total: " + arbol.peso());

        System.out.println("\nMenor: " + arbol.buscarMenor().valor);
        System.out.println("Mayor: " + arbol.buscarMayor().valor);

        arbol.eliminarNodo(70);
        System.out.println("\nRecorrido Inorden tras eliminar 70:");
        arbol.imprimirInorder(arbol.getRaiz());
    }
}

