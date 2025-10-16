package co.uniquindio.analisis_algoritmos.estructuras.ListaCircularSimple;

public class ListaCircular {
    private NodoCircular cabeza;
    private NodoCircular cola;
    private int cantidad;

    // Constructor
    public ListaCircular() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }

    // Eliminar toda la lista
    public void eliminar() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }

    // Verificar si está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Cantidad de nodos
    public int getCantidadNodos() {
        return cantidad;
    }

    // Insertar al final
    public void insertarFinal(int valor) {
        NodoCircular nuevo = new NodoCircular(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
        cantidad++;
    }

    // Insertar al inicio
    public void insertarInicio(int valor) {
        NodoCircular nuevo = new NodoCircular(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza;
        }
        cantidad++;
    }

    // Insertar en posición
    public void insertarEnPosicion(int posicion, int valor) {
        if (posicion < 0 || posicion > cantidad) {
            System.out.println("Posición inválida");
            return;
        }
        if (posicion == 0) {
            insertarInicio(valor);
        } else if (posicion == cantidad) {
            insertarFinal(valor);
        } else {
            NodoCircular nuevo = new NodoCircular(valor);
            NodoCircular temp = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.siguiente;
            }
            nuevo.siguiente = temp.siguiente;
            temp.siguiente = nuevo;
            cantidad++;
        }
    }

    // Obtener valor por posición
    public Object getValor(int posicion) {
        if (posicion < 0 || posicion >= cantidad) return null;
        NodoCircular temp = cabeza;
        for (int i = 0; i < posicion; i++) {
            temp = temp.siguiente;
        }
        return temp.valor;
    }

    // Buscar valor
    public boolean buscar(Object referencia) {
        if (estaVacia()) return false;
        NodoCircular temp = cabeza;
        do {
            if (temp.valor == (int) referencia) return true;
            temp = temp.siguiente;
        } while (temp != cabeza);
        return false;
    }

    // Obtener posición de un valor
    public int getPosicion(Object referencia) {
        if (estaVacia()) return -1;
        NodoCircular temp = cabeza;
        int pos = 0;
        do {
            if (temp.valor == (int) referencia) return pos;
            temp = temp.siguiente;
            pos++;
        } while (temp != cabeza);
        return -1;
    }

    // Remover por posición
    public void removerPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad || estaVacia()) return;

        if (posicion == 0) {
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
        } else {
            NodoCircular temp = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.siguiente;
            }
            temp.siguiente = temp.siguiente.siguiente;
            if (posicion == cantidad - 1) cola = temp;
        }
        cantidad--;
    }

    // Imprimir lista
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircular temp = cabeza;
        do {
            System.out.print(temp.valor + " -> ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("(cabeza)");
    }

    // Métodos Recursivos
    public void insertarFinalRecursivo(int valor) {
        if (estaVacia()) {
            insertarFinal(valor);
        } else {
            insertarFinalRecursivoHelper(cabeza, valor);
        }
        cantidad++;
    }

    private void insertarFinalRecursivoHelper(NodoCircular actual, int valor) {
        if (actual.siguiente == cabeza) {
            NodoCircular nuevo = new NodoCircular(valor);
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
            return;
        }
        insertarFinalRecursivoHelper(actual.siguiente, valor);
    }

    public void insertarEnPosicionRecursivo(int posicion, int valor) {
        cabeza = insertarEnPosicionRecursivoHelper(cabeza, posicion, valor);
        cantidad++;
    }

    private NodoCircular insertarEnPosicionRecursivoHelper(NodoCircular nodo, int posicion, int valor) {
        if (posicion == 0) {
            NodoCircular nuevo = new NodoCircular(valor);
            nuevo.siguiente = nodo;
            if (cola != null) cola.siguiente = nuevo;
            return nuevo;
        }
        nodo.siguiente = insertarEnPosicionRecursivoHelper(nodo.siguiente, posicion - 1, valor);
        return nodo;
    }

    public boolean buscarRecursivo(Object referencia) {
        if (estaVacia()) return false;
        return buscarRecursivoHelper(cabeza, referencia, cabeza);
    }

    private boolean buscarRecursivoHelper(NodoCircular actual, Object ref, NodoCircular inicio) {
        if (actual == null) return false;
        if (actual.valor == (int) ref) return true;
        if (actual.siguiente == inicio) return false;
        return buscarRecursivoHelper(actual.siguiente, ref, inicio);
    }
}
