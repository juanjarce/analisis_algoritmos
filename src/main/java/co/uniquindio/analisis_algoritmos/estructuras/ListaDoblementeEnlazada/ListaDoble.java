package co.uniquindio.analisis_algoritmos.estructuras.ListaDoblementeEnlazada;

public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int cantidad;

    // Constructor
    public ListaDoble() {
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
        NodoDoble nuevo = new NodoDoble(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        cantidad++;
    }

    // Insertar al inicio
    public void insertarInicio(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
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
            NodoDoble nuevo = new NodoDoble(valor);
            NodoDoble temp = cabeza;
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

    // Obtener valor en una posición
    public Object getValor(int posicion) {
        if (posicion < 0 || posicion >= cantidad) return null;
        NodoDoble temp = cabeza;
        for (int i = 0; i < posicion; i++) {
            temp = temp.siguiente;
        }
        return temp.valor;
    }

    // Buscar un valor
    public boolean buscar(Object referencia) {
        NodoDoble temp = cabeza;
        while (temp != null) {
            if (temp.valor == (int) referencia) return true;
            temp = temp.siguiente;
        }
        return false;
    }

    // Obtener posición de un valor
    public int getPosicion(Object referencia) {
        NodoDoble temp = cabeza;
        int pos = 0;
        while (temp != null) {
            if (temp.valor == (int) referencia) return pos;
            temp = temp.siguiente;
            pos++;
        }
        return -1;
    }

    // Remover por posición
    public void removerPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) return;
        if (posicion == 0) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) cabeza.anterior = null;
            else cola = null;
        } else if (posicion == cantidad - 1) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            NodoDoble temp = cabeza;
            for (int i = 0; i < posicion; i++) {
                temp = temp.siguiente;
            }
            temp.anterior.siguiente = temp.siguiente;
            temp.siguiente.anterior = temp.anterior;
        }
        cantidad--;
    }

    // Imprimir lista en orden
    public void imprimir() {
        NodoDoble temp = cabeza;
        while (temp != null) {
            System.out.print(temp.valor + " <-> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    // Insertar al final recursivo
    public void insertarFinalRecursivo(int valor) {
        if (estaVacia()) {
            insertarFinal(valor);
        } else {
            insertarFinalRecursivoHelper(cabeza, valor);
        }
        cantidad++;
    }

    private void insertarFinalRecursivoHelper(NodoDoble actual, int valor) {
        if (actual.siguiente == null) {
            NodoDoble nuevo = new NodoDoble(valor);
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            cola = nuevo;
            return;
        }
        insertarFinalRecursivoHelper(actual.siguiente, valor);
    }

    // Insertar al inicio recursivo
    public void insertarInicioRecursivo(int valor) {
        cabeza = insertarInicioRecursivoHelper(cabeza, valor);
        cantidad++;
    }

    private NodoDoble insertarInicioRecursivoHelper(NodoDoble nodo, int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (nodo == null) {
            cola = nuevo;
            return nuevo;
        }
        nuevo.siguiente = nodo;
        nodo.anterior = nuevo;
        return nuevo;
    }

    // Insertar en posición recursivo
    public void insertarEnPosicionRecursivo(int posicion, int valor) {
        cabeza = insertarEnPosicionRecursivoHelper(cabeza, posicion, valor);
        cantidad++;
    }

    private NodoDoble insertarEnPosicionRecursivoHelper(NodoDoble nodo, int posicion, int valor) {
        if (posicion == 0) {
            NodoDoble nuevo = new NodoDoble(valor);
            nuevo.siguiente = nodo;
            if (nodo != null) nodo.anterior = nuevo;
            return nuevo;
        }
        nodo.siguiente = insertarEnPosicionRecursivoHelper(nodo.siguiente, posicion - 1, valor);
        if (nodo.siguiente != null) nodo.siguiente.anterior = nodo;
        return nodo;
    }

    // Buscar recursivo
    public boolean buscarRecursivo(Object referencia) {
        return buscarRecursivoHelper(cabeza, referencia);
    }

    private boolean buscarRecursivoHelper(NodoDoble actual, Object ref) {
        if (actual == null) return false;
        if (actual.valor == (int) ref) return true;
        return buscarRecursivoHelper(actual.siguiente, ref);
    }
}

