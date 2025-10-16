package co.uniquindio.analisis_algoritmos.prog_dinamica;

public class Binomial5 {

    public static void main(String[] args) {

        System.out.println("Matriz (misterio) por tabulación: ");
        int[][] matriz = misterio(5, 5);
        imprimirMatriz(matriz);

    }

    public static int[][] misterio (int n, int k)
    {
        int [][] resultado = new int[n+1][k+1];
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= menor(i, k); j++)
            {
                if (j == 0)
                {
                    resultado[i][j] = 3 * i ;
                }
                else {
                    if (j == i)
                    {
                        resultado[i][j] = (int) Math.pow(i, j);
                    }
                    else
                    {
                        resultado[i][j] = (resultado[i-1][j-1]) +
                                (4 * resultado[i][j-1]);

                    }
                }
            }
        }
        return resultado;
    }

    public static int menor (int a, int b)
    {
        if (a<b)
        {
            return a;
        }
        else
        {
            return b;
        }
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
