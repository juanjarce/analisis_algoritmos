package co.uniquindio.analisis_algoritmos.estructuras.ListaEnlazadaSimple;

public class Lista {

    private Nodo cabeza;
    private int cantidad;

    // Constructor
    public Lista() {
        this.cabeza = null;
        this.cantidad = 0;
    }

    // Eliminar toda la lista
    public void eliminarLista() {
        cabeza = null;
        cantidad = 0;
    }
    
    // Verificar si está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Contar cantidad de nodos
    public int getCantidadNodos() {
        return cantidad;
    }
    
    // Insertar al final
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
        cantidad++;
    }
    
    // Insertar al inicio
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
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
        } else {
            Nodo nuevo = new Nodo(valor);
            Nodo temp = cabeza;
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
        Nodo temp = cabeza;
        for (int i = 0; i < posicion; i++) temp = temp.siguiente;
        return temp.valor;
    }
    
    // Buscar valor
    public boolean buscar(Object referencia) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.valor == (int) referencia) return true;
            temp = temp.siguiente;
        }
        return false;
    }

    // Obtener posición de un valor
    public int getPosicion(Object referencia) {
        Nodo temp = cabeza;
        int posicion = 0;
        while (temp != null) {
            if (temp.valor == (int) referencia) return posicion;
            temp = temp.siguiente;
            posicion++;
        }
        return -1;
    }

    // Remover por posición
    public void removerPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) return;
        if (posicion == 0) cabeza = cabeza.siguiente;
        else {
            Nodo temp = cabeza;
            for (int i = 0; i < posicion - 1; i++) temp = temp.siguiente;
            temp.siguiente = temp.siguiente.siguiente;
        }
        cantidad--;
    }

    // Imprimir lista
    public void imprimir() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.valor + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
    
    // Métodos recursivos
    public boolean buscarRecursivo(Object referencia) {
        return buscarRecursivoHelper(cabeza, referencia);
    }

    private boolean buscarRecursivoHelper(Nodo nodo, Object ref) {
        if (nodo == null) return false;
        if (nodo.valor == (int) ref) return true;
        return buscarRecursivoHelper(nodo.siguiente, ref);
    }

    public void insertarFinalRecusivo(int valor) {
        cabeza = insertarFinalRecusivoHelper(cabeza, valor);
        cantidad++;
    }

    private Nodo insertarFinalRecusivoHelper(Nodo nodo, int valor) {
        if (nodo == null) return new Nodo(valor);
        nodo.siguiente = insertarFinalRecusivoHelper(nodo.siguiente, valor);
        return nodo;
    }

    public void removerEnPosicionRecursivo(int posicion) {
        cabeza = removerEnPosicionRecursivoHelper(cabeza, posicion);
        cantidad--;
    }

    private Nodo removerEnPosicionRecursivoHelper(Nodo nodo, int posicion) {
        if (nodo == null) return null;
        if (posicion == 0) return nodo.siguiente;
        nodo.siguiente = removerEnPosicionRecursivoHelper(nodo.siguiente, posicion - 1);
        return nodo;
    }

    public void insertarEnPosicionRecursivo(int posicion, int valor) {
        cabeza = insertarEnPosicionRecursivoHelper(cabeza, posicion, valor);
        cantidad++;
    }

    private Nodo insertarEnPosicionRecursivoHelper(Nodo nodo, int posicion, int valor) {
        if (posicion == 0) {
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = nodo;
            return nuevo;
        }
        nodo.siguiente = insertarEnPosicionRecursivoHelper(nodo.siguiente, posicion - 1, valor);
        return nodo;
    }
}

