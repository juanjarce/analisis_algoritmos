package co.uniquindio.analisis_algoritmos.recursivos;

public class ContadorVocales {
    public static void main(String[] args) {
        String pal = "estebandido";
        int numVocales = contadorVocales(pal, 0);
        System.out.println("El numero de vocales en "+pal+" es: "+numVocales);
    }

    // Función recursiva para:
    // Escriba un algoritmo recursivo que retorne la cantidad de vocales que tiene una cadena de caracteres.
    public static int contadorVocales(String pal, int i) {
        // Caso base: limite de la palabra
        if(i >= pal.length()){
            return 0;
        }
        // Recursión: recorrer la palabra y contar las vocales
        char letra = pal.charAt(i);
        letra = Character.toLowerCase(letra);
        if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
            return 1 + contadorVocales(pal, i + 1);
        }
        else{
            return contadorVocales(pal, i + 1);
        }
    }
}
