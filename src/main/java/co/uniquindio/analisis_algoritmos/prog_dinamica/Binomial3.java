package co.uniquindio.analisis_algoritmos.prog_dinamica;

public class Binomial3 {

    public static void main(String[] args) {

        System.out.println("Matriz Binomial (iterativo y recursivo): ");
        int[][] result1 = llenarMatrizBinomial(5, 5);
        imprimirMatriz(result1);

        System.out.println("\nMatriz Binomial por tabulacion: ");
        int[][] result2 = llenarBinomiales(5, 5);
        imprimirMatriz(result2);

    }

    // Metodos para la matriz binomial (Memorización) -----------------------------------------------------
    public static int binomial(int n, int k, int[][] matrix) {
        if(k == 0 || k == n){
            matrix[n][k] = 2;
            return 2;
        }
        if(matrix[n][k] != 0){
            return matrix[n][k];
        }
        matrix[n][k] = binomial(n, k-1, matrix) + binomial(n-1, k-1, matrix) + binomial(n-1, k, matrix);
        return matrix[n][k];
    }

    public static int[][] llenarMatrizBinomial(int n, int k) {
       int[][] result = new int[n+1][k+1];

       for(int i = 1; i <= n; i++){
           for(int j = 1; j <= Math.min(i, k); j++){
               result[i][j] = binomial(i, j, result);
           }
       }
       return result;
    }

    // Metodos para la matriz binomial (Tabulación) -----------------------------------------------------
    public static int[][] llenarBinomiales(int n, int k) {
        int [][] result = new int[n+1][k+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= Math.min(i, k); j++){
                if(j == 0 || j == i){
                    result[i][j] = 2;
                }
                else{
                    result[i][j] = result[i][j-1] + result[i-1][j-1] + result[i-1][j];
                }
            }
        }
        return result;
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
