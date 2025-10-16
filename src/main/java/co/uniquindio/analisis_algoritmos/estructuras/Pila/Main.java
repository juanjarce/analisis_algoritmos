package co.uniquindio.analisis_algoritmos.estructuras.Pila;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();

        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.imprimir();

        System.out.println("Elemento en tope: " + pila.top());
        System.out.println("Elemento eliminado: " + pila.pop());
        pila.imprimir();
    }
}

