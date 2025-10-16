package co.uniquindio.analisis_algoritmos.iterativos;

public class EncadenamientoValido {

    public static void main(String[] args) {
        // Ejemplo del enunciado
        String[][] palabras = {
                {"Sien", "encima", "mapa"},
                {"Pata", "tapa", "papa"},
                {"Pato", "toma", "mama"}
        };

        if (isEncadenado(palabras)) {
            System.out.println("✅ La lista de palabras es válida.");
        } else {
            System.out.println("❌ La lista de palabras NO es válida.");
        }
    }


    public static boolean isEncadenado(String[][] matriz){
        // Obtenemos las dimensiones de la matriz
        int n = matriz.length;
        int m = matriz[0].length;

        // Declaramos las variables necesarios
        String pal1; String pal2;
        String comienzo; String fin;

        // Recorremos la matriz (for para cada fila)
        for(int i = 0; i < n; i++){
            // Recorremos cada colummna de la fila
            for(int j = 0; j < m - 1; j++){
                pal1 = matriz[i][j];
                pal2 = matriz[i][j+1];
                fin = pal1.substring(pal1.length()-2).toLowerCase();
                comienzo = pal2.substring(0, 2).toLowerCase();

                // Comparamos para combrobar que esten encadenadas
                if(!fin.equals(comienzo)){
                    return false;
                }
            }
        }
        return true;
    }
}
