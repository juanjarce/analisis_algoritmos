package co.uniquindio.analisis_algoritmos.estructuras.Cola;

public class Cola {
    private NodoCola frente;  // primer elemento (head)
    private NodoCola fin;     // último elemento (tail)
    private int cantidad;

    // Constructor
    public Cola() {
        frente = null;
        fin = null;
        cantidad = 0;
        // Complejidad: O(1)
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Agregar elemento al final de la cola (enqueue)
    public void enqueue(Object nuevo) {
        NodoCola nodo = new NodoCola(nuevo);
        if (estaVacia()) {
            frente = nodo;
            fin = nodo;
        } else {
            fin.siguiente = nodo;
            fin = nodo;
        }
        cantidad++;
    }

    // Retornar el elemento del frente (sin eliminar)
    public Object front() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return frente.valor;
    }

    // Eliminar el elemento del frente (dequeue)
    public Object dequeue() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Object valor = frente.valor;
        frente = frente.siguiente; // el siguiente nodo pasa a ser el frente
        if (frente == null) fin = null; // si se vacía, reinicia también el final
        cantidad--;
        return valor;
    }

    // Obtener el tamaño de la cola
    public int size() {
        return cantidad;
    }

    // Imprimir los elementos de la cola
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Cola vacía");
            return;
        }
        NodoCola temp = frente;
        System.out.print("FRENTE -> ");
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
        System.out.println("<- FINAL");
    }
}

