package co.uniquindio.analisis_algoritmos.estructuras.Pila;

public class Pila {
    private NodoPila tope;   // referencia al último nodo insertado
    private int cantidad;

    // Constructor
    public Pila() {
        tope = null;
        cantidad = 0;
    }
    
    // Verificar si la pila está vacía
    public boolean estaVacia() {
        return tope == null;
    }

    // Agregar un elemento a la pila (Push)
    public void push(Object valor) {
        NodoPila nuevo = new NodoPila(valor);
        nuevo.siguiente = tope;  // el nuevo nodo apunta al antiguo tope
        tope = nuevo;            // ahora el nuevo nodo es el tope
        cantidad++;
    }
    
    // Obtener el elemento del tope sin eliminarlo (Top o Peek)
    public Object top() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return tope.valor;
    }
    
    // Eliminar el elemento del tope (Pop)
    public Object pop() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return null;
        }
        Object valor = tope.valor;
        tope = tope.siguiente; // mueve el tope al siguiente nodo
        cantidad--;
        return valor;
    }

    // Obtener la cantidad de elementos en la pila
    public int getCantidad() {
        return cantidad;
    }
    
    // Imprimir todos los elementos de la pila
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return;
        }
        NodoPila temp = tope;
        System.out.print("TOPE -> ");
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
        System.out.println("<- BASE");
        // Complejidad: O(n)
    }
}

