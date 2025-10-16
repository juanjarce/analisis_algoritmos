package co.uniquindio.analisis_algoritmos.estructuras.ListaCircularDoblementeEnlazada;

public class NodoCircularDoble {
    int valor;
    NodoCircularDoble siguiente;
    NodoCircularDoble anterior;

    public NodoCircularDoble(int valor) {
        this.valor = valor;
        this.siguiente = this.anterior = null;
    }
}

