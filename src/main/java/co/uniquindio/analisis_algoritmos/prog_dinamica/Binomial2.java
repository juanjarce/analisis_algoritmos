package co.uniquindio.analisis_algoritmos.prog_dinamica;

public class Binomial2 {

    public static void main(String[] args) {

        System.out.println("Matriz Binomial por tabulación: ");
        int[][] result = llenarMatrizBinomialTabulacion(5, 5);
        imprimirMatriz(result);

    }

    // Metodos para la matriz binomial (Tabulación) -----------------------------------------------------
    public static int[][] llenarMatrizBinomialTabulacion(int n, int k) {
        int[][] matriz = new int[n+1][k+1];
        for(int i = 0; i <= n; i++){
            for(int j=0; j <= Math.min(i,k); j++){
                if(j == 0){
                    matriz[i][j] = 1;
                }
                else{
                    if(j == i){
                        matriz[i][j] = (int) Math.pow(i, i);
                    }
                    else{
                        matriz[i][j] = 2* matriz[i-1][j-1] + 3 * matriz[i-1][j];
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
