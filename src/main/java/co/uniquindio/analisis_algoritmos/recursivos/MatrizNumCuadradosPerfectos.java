package co.uniquindio.analisis_algoritmos.recursivos;

public class MatrizNumCuadradosPerfectos {
    public static void main(String[] args) {
        // Matriz de String (2x2) inicializada con "" en cada posición
        String[][] result = {
                {"", ""},
                {"", ""}
        };

        // Matriz de int (2x2) con los elementos 4, 8, 12, 4
        int[][] matriz = {
                {4, 8},
                {12, 4}
        };

        result = matrizInfoCP(matriz, result, 0, 0);

        System.out.println("Resultado de Strings:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print("\"" + result[i][j] + "\" ");
            }
            System.out.println();
        }
    }

    // Función recursiva para:
    // Encontrar minimo muliplo para convertir un numero en cuadrado perfecto
    public static int encontrarMultiploCP(int num, int i){
        // Caso base: el indice 'i' convierte a num en cuadrado perfecto
        double raiz = Math.sqrt(num * i);
        if(raiz % 1 == 0){
            return i;
        }
        // Recursión se intenta con el siguiente numero
        return encontrarMultiploCP(num, i+1);
    }

    /**
     * “Un número es un cuadrado perfecto si su raíz cuadrada es un número entero (sin
       decimales). Por ejemplo, el 4 es un cuadrado perfecto (22), al igual que lo son el 36 (62) y el
       3.500.641 (18712). Todos los números que no son cuadrados perfectos pueden multiplicarse
       por otros para conseguir serlo. Por ejemplo, el número 8 no es un cuadrado perfecto, pero
       al multiplicarlo por 2 se obtiene el 16, que sí lo es”1.
     * Dada una matriz, evaluar por cada posición [i][j] de la misma si el número dado corresponde a un
       cuadrado perfecto. Se debe devolver una matriz informan do para cada posición el número más
       pequeño que al ser multiplicado por el número del caso de prueba da como resultado un cuadrado
       perfecto. Ejemplo: Si se tiene la siguiente matriz:
     */
    public static String[][] matrizInfoCP(int[][] matriz, String[][] result, int i, int j){
        // Caso base: limite de la matriz (final)
        if(i >= matriz.length){
            return result;
        }
        // se pone la informacion del numero en la posición [i][j]
        double raiz = Math.sqrt(matriz[i][j]);
        if(raiz % 1 == 0){
            result[i][j] = matriz[i][j]+" /*Es cuadrado perfecto, se multiplica\n" +
                    "por 1 para no alterar su estado de cuadrado perfecto*/";
        }
        else{
            int mult = encontrarMultiploCP(matriz[i][j], 1);
            result[i][j] = "/* El "+matriz[i][j]+" no es cuadrado perfecto, pero si se\n" +
                    "multiplica por "+mult+" , da "+matriz[i][j] * mult+" que si es cuadrado\n" +
                    "perfecto*/";
        }
        // Recursión: se recorre toda la matriz, para poner la info de cada elemento
        if(j < matriz[i].length-1){
            return matrizInfoCP(matriz, result, i, j+1);
        }
        else{
            return matrizInfoCP(matriz, result, i+1, 0);
        }
    }

}
