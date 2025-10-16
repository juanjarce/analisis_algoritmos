package co.uniquindio.analisis_algoritmos.prog_dinamica;

public class Binomial1 {

    public static void main(String[] args) {

        System.out.println("Matriz Binomial por memorización: ");
        int[][] matriz = new int[7][7];
        llenarMatrizBinomial(5, 0, 0, matriz);
        imprimirMatriz(matriz);

        System.out.println("\nMatriz Binomial por tabulación: ");
        int[][] tabulacion = llenarMatrizBinomialTabulacion(5, 5);
        imprimirMatriz(tabulacion);

    }

    // Metodos para la matriz binomial (Memorización) -----------------------------------------------------
    public static int binomial(int n, int k, int[][] matrix) {
        if(k == 0){
            matrix[n][k] = 3;
            return 3;
        }
        if(k == n){
            if(matrix[n][k] != 0){
                return matrix[n][k];
            }
            else{
                matrix[n][k] = binomial(n, k-1, matrix);
                return matrix[n][k];
            }
        }
        if(matrix[n][k] != 0){
            return matrix[n][k];
        }
        matrix[n][k] = binomial(n, k-1, matrix) + binomial(n-1, k, matrix);
        return matrix[n][k];
    }

    public static void llenarMatrizBinomial(int n, int i, int j, int[][] matrix) {
        if(i > n){
            return ;
        }

        binomial(i, j, matrix);
        if(j < i){
            llenarMatrizBinomial(n, i, j+1, matrix);
        }
        else{
            llenarMatrizBinomial(n, i+1, 0, matrix);
        }
    }

    // Metodos para la matriz binomial (Tabulación) -----------------------------------------------------
    public static int[][] llenarMatrizBinomialTabulacion(int n, int k) {
        int[][] matriz = new int[n+1][k+1];
        for(int i = 0; i <= n; i++){
            for(int j=0; j <= Math.min(i,k); j++){
                if(j == 0){
                    matriz[i][j] = 3;
                }
                else{
                    if(j == i){
                        matriz[i][j] = matriz[i][j-1];
                    }
                    else{
                        matriz[i][j] = matriz[i][j-1] + matriz[i-1][j];
                    }
                }
            }
        }
        return matriz;
    }

    // Metodos adicionales (Utiles) -----------------------------------------------------
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Salto de línea al terminar una fila
        }
    }

}
