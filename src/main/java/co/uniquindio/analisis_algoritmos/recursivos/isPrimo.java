package co.uniquindio.analisis_algoritmos.recursivos;

public class isPrimo {
    public static void main(String[] args) {
        int num = 12;
        boolean primo = isPrimo(num, 2);

        System.out.println("El numero: "+num+" Es un numero primo: "+ primo);
    }

    // Función recursiva para determinar:
    // Determinar si un número entero positivo es primo o no lo es.
    public static boolean isPrimo(int num, int i) {
        // Caso base 1: el indice llega al mismo numero y no encuentra divisor
        if(i == num){
            return true;
        }
        // Caso base 2: se encuentra un divisor
        if(num % i == 0){
            return false;
        }
        return isPrimo(num, i+1);
    }
}
