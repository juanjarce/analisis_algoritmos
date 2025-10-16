package co.uniquindio.analisis_algoritmos.prog_dinamica;

public class Algoritmo1 {

    public static void main(String[] args) {
        int n = 9;
        int result1 = algoritmo1Recursivo(n);
        System.out.println("Resultado con el algoritmo recursivo: " + result1);
        int result2 = algoritmo1Iterativo(n);
        System.out.println("\nResultado con el algoritmo iterativo: " + result1);
        int result3 = algoritmo1Tabulacion(n);
        System.out.println("\nResultado con el algoritmo por tabulación: " + result1);
    }

    public static int algoritmo1Recursivo(int n) {
        if(n == 0){
            return 3;
        }
        if(n == 1){
            return 1;
        }
        return algoritmo1Recursivo(n-2) + algoritmo1Recursivo(n-2);
    }

    public static int algoritmo1Iterativo(int n) {
        int sum = 0;
        int result = 0;
        int n1 = 3;
        int n2 = 1;

        if(n == 0) return 3;
        if(n == 1) return 1;

        for(int i = 2; i <= n; i++){
            sum = n1 + n2;
            result += sum;
            n1 = n2;
            n2 = sum;
        }
        return result;
    }

    public static int algoritmo1Tabulacion(int n) {
        int[] arr = new int[n+1];
        if(n >= 0){
            arr[0] = 3;
        }
        if(n >= 1){
            arr[1] = 1;
        }
        for(int i = 2; i <= n; i++){
            if(arr[i] == 0){
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr[n];
    }
}
