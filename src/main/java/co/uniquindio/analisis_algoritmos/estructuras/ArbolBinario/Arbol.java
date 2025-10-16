package co.uniquindio.analisis_algoritmos.estructuras.ArbolBinario;

public class Arbol {
    private NodoArbol raiz;

    // Constructor
    public Arbol() {
        raiz = null;
    }

    // Buscar un nodo
    public boolean buscar(NodoArbol nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        else if (valor < nodo.valor)
            return buscar(nodo.izquierdo, valor);
        else
            return buscar(nodo.derecho, valor);
    }

    // Insertar un nodo
    public void insertarNodo(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbol insertarRec(NodoArbol nodo, int valor) {
        if (nodo == null) return new NodoArbol(valor);
        if (valor < nodo.valor)
            nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertarRec(nodo.derecho, valor);
        return nodo;
    }

    // Eliminar un nodo
    public void eliminarNodo(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoArbol eliminarRec(NodoArbol nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.valor)
            nodo.izquierdo = eliminarRec(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = eliminarRec(nodo.derecho, valor);
        else {
            // Caso 1: sin hijos
            if (nodo.izquierdo == null && nodo.derecho == null)
                return null;
                // Caso 2: un solo hijo
            else if (nodo.izquierdo == null)
                return nodo.derecho;
            else if (nodo.derecho == null)
                return nodo.izquierdo;
                // Caso 3: dos hijos
            else {
                NodoArbol sucesor = buscarMenor(nodo.derecho);
                nodo.valor = sucesor.valor;
                nodo.derecho = eliminarRec(nodo.derecho, sucesor.valor);
            }
        }
        return nodo;
    }

    // Eliminar un subárbol (dado un nodo)
    public void eliminarSubArbol(NodoArbol nodo) {
        if (nodo == null) return;
        nodo.izquierdo = null;
        nodo.derecho = null;
        nodo = null;
    }

    // Buscar el menor valor
    public NodoArbol buscarMenor(NodoArbol nodo) {
        if (nodo == null) return null;
        while (nodo.izquierdo != null)
            nodo = nodo.izquierdo;
        return nodo;
    }

    public NodoArbol buscarMenor() {
        return buscarMenor(raiz);
    }

    // Buscar el mayor valor
    public NodoArbol buscarMayor(NodoArbol nodo) {
        if (nodo == null) return null;
        while (nodo.derecho != null)
            nodo = nodo.derecho;
        return nodo;
    }

    public NodoArbol buscarMayor() {
        return buscarMayor(raiz);
    }

    // Eliminar el menor nodo
    public NodoArbol eliminarMenor() {
        if (raiz == null) return null;
        raiz = eliminarMenorRec(raiz);
        return raiz;
    }

    private NodoArbol eliminarMenorRec(NodoArbol nodo) {
        if (nodo.izquierdo == null)
            return nodo.derecho;
        nodo.izquierdo = eliminarMenorRec(nodo.izquierdo);
        return nodo;
    }

    // Eliminar el mayor nodo
    public NodoArbol eliminarMayor() {
        if (raiz == null) return null;
        raiz = eliminarMayorRec(raiz);
        return raiz;
    }

    private NodoArbol eliminarMayorRec(NodoArbol nodo) {
        if (nodo.derecho == null)
            return nodo.izquierdo;
        nodo.derecho = eliminarMayorRec(nodo.derecho);
        return nodo;
    }

    // Calcular altura del árbol
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol nodo) {
        if (nodo == null) return 0;
        int izq = alturaRec(nodo.izquierdo);
        int der = alturaRec(nodo.derecho);
        return Math.max(izq, der) + 1;
    }

    // Cantidad total de nodos
    public int cantidadNodos() {
        return cantidadRec(raiz);
    }

    private int cantidadRec(NodoArbol nodo) {
        if (nodo == null) return 0;
        return 1 + cantidadRec(nodo.izquierdo) + cantidadRec(nodo.derecho);
    }

    // Peso del árbol (suma de los valores de los nodos)
    public int peso() {
        return pesoRec(raiz);
    }

    private int pesoRec(NodoArbol nodo) {
        if (nodo == null) return 0;
        return nodo.valor + pesoRec(nodo.izquierdo) + pesoRec(nodo.derecho);
    }

    // Recorridos
    public void imprimirInorder(NodoArbol nodo) {
        if (nodo == null) return;
        imprimirInorder(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        imprimirInorder(nodo.derecho);
    }

    public void imprimirPostorder(NodoArbol nodo) {
        if (nodo == null) return;
        imprimirPostorder(nodo.izquierdo);
        imprimirPostorder(nodo.derecho);
        System.out.print(nodo.valor + " ");
    }

    public void imprimirPreorder(NodoArbol nodo) {
        if (nodo == null) return;
        System.out.print(nodo.valor + " ");
        imprimirPreorder(nodo.izquierdo);
        imprimirPreorder(nodo.derecho);
    }

    // Getter de la raíz
    public NodoArbol getRaiz() {
        return raiz;
    }
}

