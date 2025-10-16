package co.uniquindio.analisis_algoritmos.prog_dinamica;

public class Algoritmo2 {

    public static void main(String[] args) {
        int n = 9;

        int result1 = algoritmo2Recursivo(n);
        System.out.println("Resultado del algoritmo recursivo: " + result1);
        int result2 = algoritmo2Iterativo(n);
        System.out.println("Resultado del algoritmo iterativo: " + result2);
        int result3 = algoritmo2Tabulacion(n);
        System.out.println("Resultado del algoritmo por tabulación: " + result3);
        int[] arr = new int[n+1];
        int result4 = algoritmo2Memorizacion(n, arr);
        System.out.println("Resultado del algoritmo por memorización: " + result4);
    }

    public static int algoritmo2Recursivo(int n){
        if(n == 0) return 3;
        if(n == 1) return 2;
        if(n == 2) return 1;

        return algoritmo2Recursivo(n-1) * n;
    }

    public static int algoritmo2Iterativo(int n){
        if(n == 0) return 3;
        if(n == 1) return 2;
        if(n == 2) return 1;
        int result = 1;
        int pasado = 1;
        for(int i = 3; i <= n; i++){
            result = pasado * i;
            pasado = result;
        }
        return result;
    }

    public static int algoritmo2Tabulacion(int n){
        int[] arr = new int[n+1];
        if(n >= 0) arr[0] = 3;
        if(n >= 1) arr[1] = 2;
        if(n >= 2) arr[2] = 1;

        for(int i = 3; i <= n; i++){
            arr[i] = arr[i-1] * i;
        }
        return arr[n];
    }

    public static int algoritmo2Memorizacion(int n, int[] arr){
        if(n == 0) return 3;
        if(n == 1) return 2;
        if(n == 2) return 1;

        if(arr[n] != 0){
            return arr[n];
        }
        arr[n] = algoritmo2Memorizacion(n-1, arr) * n;
        return arr[n];
    }

}
