package co.uniquindio.analisis_algoritmos.recursivos;

public class SumaElementosMatriz {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3, 4, 6},
                {2, 5, -6, 7, 7},
                {3, 6, 8, 9, 6},
                {4, 7, 9, 10, -5}
        };
        int suma = sumarElementos(matriz, 0, 0);
        System.out.println("La suma de los elementos de la matriz es: "+suma);

        int sumaReves = sumarElementosReves(matriz, matriz.length - 1, matriz[0].length - 1);
        System.out.println("La suma de los elementos de la matriz es (Recorrido al revés): "+sumaReves);
    }

    // Función recursiva para:
    // Escriba un algoritmo recursivo que dado un arreglo bidimensional de números enteros, retorne
    // suma de los elementos positivos que hay dentro del arreglo.
    public static int sumarElementos(int[][] matriz, int i, int j) {
        // Caso base: limite de la matriz
        if(i >= matriz.length){
            return 0;
        }
        // Recursión: recorrer la matriz [i][j] y sumar los elementos positivos
        int elem = matriz[i][j];
        if(j < matriz[i].length-1){
            if(elem >= 0){
                return elem + sumarElementos(matriz, i, j+1);
            }
            else{
                return sumarElementos(matriz, i, j+1);
            }
        }
        else{
            if(elem >= 0){
                return elem + sumarElementos(matriz, i+1, 0);
            }
            else{
                return sumarElementos(matriz, i+1, 0);
            }
        }
    }

    public static int sumarElementosReves(int[][] matriz, int i, int j) {
        // Caso base: limite de la matriz
        if(i < 0){
            return 0;
        }
        // Recursión: recorrer la matriz [i][j] y sumar los elementos positivos
        int elem = matriz[i][j];
        if(j > 0){
            if(elem >= 0){
                return elem + sumarElementosReves(matriz, i, j-1);
            }
            else{
                return sumarElementosReves(matriz, i, j-1);
            }
        }
        else{
            if(elem >= 0){
                return elem + sumarElementosReves(matriz, i-1, matriz[0].length - 1);
            }
            else{
                return sumarElementosReves(matriz, i-1, matriz[0].length - 1);
            }
        }
    }
}
