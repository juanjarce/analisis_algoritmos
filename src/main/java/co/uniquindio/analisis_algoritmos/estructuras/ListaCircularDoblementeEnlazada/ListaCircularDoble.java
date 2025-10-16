package co.uniquindio.analisis_algoritmos.estructuras.ListaCircularDoblementeEnlazada;

public class ListaCircularDoble {
    private NodoCircularDoble cabeza;
    private NodoCircularDoble cola;
    private int cantidad;

    // Constructor
    public ListaCircularDoble() {
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

    // Obtener cantidad de nodos
    public int getCantidadNodos() {
        return cantidad;
    }

    // Insertar al final
    public void insertarFinal(int valor) {
        NodoCircularDoble nuevo = new NodoCircularDoble(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cola.siguiente = nuevo;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }
        cantidad++;
    }

    // Insertar al inicio
    public void insertarInicio(int valor) {
        NodoCircularDoble nuevo = new NodoCircularDoble(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            nuevo.anterior = cola;
            cabeza.anterior = nuevo;
            cola.siguiente = nuevo;
            cabeza = nuevo;
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
            NodoCircularDoble nuevo = new NodoCircularDoble(valor);
            NodoCircularDoble temp = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.siguiente;
            }
            nuevo.siguiente = temp.siguiente;
            nuevo.anterior = temp;
            temp.siguiente.anterior = nuevo;
            temp.siguiente = nuevo;
            cantidad++;
        }
    }

    // Obtener valor por posición
    public Object getValor(int posicion) {
        if (posicion < 0 || posicion >= cantidad) return null;
        NodoCircularDoble temp = cabeza;
        for (int i = 0; i < posicion; i++) {
            temp = temp.siguiente;
        }
        return temp.valor;
    }

    // Buscar un valor
    public boolean buscar(Object referencia) {
        if (estaVacia()) return false;
        NodoCircularDoble temp = cabeza;
        do {
            if (temp.valor == (int) referencia) return true;
            temp = temp.siguiente;
        } while (temp != cabeza);
        return false;
    }

    // Obtener posición de un valor
    public int getPosicion(Object referencia) {
        if (estaVacia()) return -1;
        NodoCircularDoble temp = cabeza;
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

        if (cantidad == 1) {
            cabeza = null;
            cola = null;
        } else if (posicion == 0) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = cola;
            cola.siguiente = cabeza;
        } else if (posicion == cantidad - 1) {
            cola = cola.anterior;
            cola.siguiente = cabeza;
            cabeza.anterior = cola;
        } else {
            NodoCircularDoble temp = cabeza;
            for (int i = 0; i < posicion; i++) {
                temp = temp.siguiente;
            }
            temp.anterior.siguiente = temp.siguiente;
            temp.siguiente.anterior = temp.anterior;
        }
        cantidad--;
    }

    // Imprimir lista
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircularDoble temp = cabeza;
        do {
            System.out.print(temp.valor + " <-> ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("(inicio)");
    }

    // Métodos recursivos
    public void insertarFinalRecursivo(int valor) {
        if (estaVacia()) {
            insertarFinal(valor);
        } else {
            insertarFinalRecursivoHelper(cabeza, valor);
        }
        cantidad++;
    }

    private void insertarFinalRecursivoHelper(NodoCircularDoble actual, int valor) {
        if (actual.siguiente == cabeza) {
            NodoCircularDoble nuevo = new NodoCircularDoble(valor);
            nuevo.anterior = actual;
            nuevo.siguiente = cabeza;
            actual.siguiente = nuevo;
            cabeza.anterior = nuevo;
            cola = nuevo;
            return;
        }
        insertarFinalRecursivoHelper(actual.siguiente, valor);
    }

    public void insertarInicioRecursivo(int valor) {
        insertarInicio(valor);
    }

    public void insertarEnPosicionRecursivo(int posicion, int valor) {
        cabeza = insertarEnPosicionRecursivoHelper(cabeza, posicion, valor);
        cantidad++;
    }

    private NodoCircularDoble insertarEnPosicionRecursivoHelper(NodoCircularDoble nodo, int posicion, int valor) {
        if (posicion == 0) {
            NodoCircularDoble nuevo = new NodoCircularDoble(valor);
            nuevo.siguiente = nodo;
            nuevo.anterior = nodo.anterior;
            nodo.anterior.siguiente = nuevo;
            nodo.anterior = nuevo;
            if (nodo == cabeza) cabeza = nuevo;
            return cabeza;
        }
        insertarEnPosicionRecursivoHelper(nodo.siguiente, posicion - 1, valor);
        return nodo;
    }

    public boolean buscarRecursivo(Object referencia) {
        if (estaVacia()) return false;
        return buscarRecursivoHelper(cabeza, referencia, cabeza);
    }

    private boolean buscarRecursivoHelper(NodoCircularDoble actual, Object ref, NodoCircularDoble inicio) {
        if (actual.valor == (int) ref) return true;
        if (actual.siguiente == inicio) return false;
        return buscarRecursivoHelper(actual.siguiente, ref, inicio);
    }
}

