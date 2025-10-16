package co.uniquindio.analisis_algoritmos.recursivos;

public class MatrizSimetrica {
    public static void main(String[] args) {
        // Definir una matriz cuadrada
        int[][] matriz = {
                {1, 2, 3, 4},
                {2, 5, 6, 7},
                {3, 6, 8, 9},
                {4, 7, 9, 10}
        };
        boolean simetrica = isMatrizSimetrica(matriz, 0, 0);
        System.out.println("El matriz simetrica: "+simetrica);
    }

    // Función recursiva para determinar:
    // Una matriz es simétrica si es una matriz cuadrada, la cual tiene la característica de ser igual a
    // su traspuesta. Una matriz simétrica tiene iguales los elementos que guardan una posición
    // simétrica con relación a la diagonal principal.
    public static boolean isMatrizSimetrica(int[][] matriz, int i, int j) {
        // Caso base 1: se llega al limite de la matriz
        if ( i >= matriz.length){
            return true;
        }
        // Caso base 2: la matriz no es cuadrada
        if (matriz.length != matriz[i].length) {
            return false;
        }
        // Caso base 3: se encuentra un elemento diferente [i][j] != [j][i]
        if( matriz[i][j] != matriz[j][i]){
            return false;
        }
        if(j < matriz[i].length - 1){
            return isMatrizSimetrica(matriz, i, j+1);
        }
        else{
            return isMatrizSimetrica(matriz, i+1, 0);
        }
    }
}
