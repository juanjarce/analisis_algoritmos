package co.uniquindio.analisis_algoritmos.prog_dinamica;

public class Algoritmo3 {

    public static void main(String[] args) {
        int n = 9;

        int result1 = algoritmo3Recursivo(n);
        System.out.println("Resultado del algoritmo recursivo: " + result1);
        int result2 = algoritmo3Tabulacion(n);
        System.out.println("Resultado del algoritmo por tabulación: " + result2);
    }

    public static int algoritmo3Recursivo(int n) {
        if(n==0) return 3;
        if(n==1) return 2;
        if(n==2) return 1;

        return algoritmo3Recursivo(n-1)+algoritmo3Recursivo(n-2)+algoritmo3Recursivo(n-3);
    }

    public static int algoritmo3Tabulacion(int n) {
        int[] arr = new int[n+1];

        if(n >= 0) arr[0] = 3;
        if(n >= 1) arr[1] = 2;
        if(n >= 2) arr[2] = 1;

        for(int i=3; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        return arr[n];
    }
}
