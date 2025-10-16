package co.uniquindio.analisis_algoritmos.estructuras.Cola;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();

        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");
        cola.imprimir();

        System.out.println("Elemento al frente: " + cola.front());
        System.out.println("Eliminando: " + cola.dequeue());
        cola.imprimir();

        System.out.println("Tamaño actual: " + cola.size());
    }
}

