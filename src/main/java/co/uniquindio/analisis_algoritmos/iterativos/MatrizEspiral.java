package co.uniquindio.analisis_algoritmos.iterativos;

public class MatrizEspiral {

    public static void main(String[] args) {
        // variables necesarios
        int n = 5;

        int[][] matriz = matrizEspiral2(n);

        // imprimimos el resultado
        imprimirMatriz(matriz);
    }

    public static int[][] matrizEspiral(int n) {
        // Creamos una matriz de tamanio (nxn)
        int[][] matriz = new int[n][n];

        int valor = 1;
        // Declaramos los limites de la matriz
        int filaInicio = 0; int filaFinal= n - 1;
        int colInicio = 0; int colFinal= n - 1;

        // Ciclo mientras se colocan todas posiciones de la matriz (nxn)
        while(valor <= n*n){
            // Recorrido ultima columna (abajo -> arriba)
            for(int i=filaFinal; i>=filaInicio; i--){
                matriz[i][colFinal] = valor;
                valor++;
            }
            colFinal--;

            // Recorrido de la primera fila (derecha -> izquierda)
            for(int i=colFinal; i>=colInicio; i--){
                matriz[filaInicio][i]=valor;
                valor++;
            }
            filaInicio++;

            // Recorrido en la primera columna (arriba -> abajo)
            for(int i=filaInicio; i<=filaFinal; i++){
                matriz[i][colInicio]=valor;
                valor++;
            }
            colInicio++;

            // Recorrido en la ultima fila (izquierda -> derecha)
            for(int i=colInicio; i<=colFinal; i++){
                matriz[filaFinal][i]=valor;
                valor++;
            }
            filaFinal--;
        }
        return matriz;
    }

    public static int[][] matrizEspiral2(int n) {
        // Creamos una matriz de tamanio (nxn)
        int[][] matriz = new int[n][n];

        int valor = 1;
        // Declaramos los limites de la matriz
        int filaInicio = 0; int filaFinal= n - 1;
        int colInicio = 0; int colFinal= n - 1;

        // Ciclo mientras se colocan todas posiciones de la matriz (nxn)
        while(valor <= n*n){
            // Recorrido ultima columna (abajo -> arriba)
            for(int i=n-1; i>=0; i--){
                if(filaFinal >= i && i >= filaInicio){
                    matriz[i][colFinal] = valor;
                    valor++;
                }
            }
            colFinal--;

            // Recorrido de la primera fila (derecha -> izquierda)
            for(int i=n-1; i>=0; i--){
                if(colFinal >= i && i >= colInicio){
                    matriz[filaInicio][i]=valor;
                    valor++;
                }
            }
            filaInicio++;

            // Recorrido en la primera columna (arriba -> abajo)
            for(int i=0; i<=n-1; i++){
                if(i >= filaInicio && i <= filaFinal){
                    matriz[i][colInicio]=valor;
                    valor++;
                }
            }
            colInicio++;

            // Recorrido en la ultima fila (izquierda -> derecha)
            for(int i=0; i<=n-1; i++){
                if(i >= colInicio && i <= colFinal){
                    matriz[filaFinal][i]=valor;
                    valor++;
                }
            }
            filaFinal--;
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t"); // "\t" agrega tabulación para que quede alineado
            }
            System.out.println(); // salto de línea al terminar cada fila
        }
    }

}
