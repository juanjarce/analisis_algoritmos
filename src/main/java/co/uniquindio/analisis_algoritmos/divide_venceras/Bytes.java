package co.uniquindio.analisis_algoritmos.divide_venceras;

public class Bytes {

    public static void main(String[] args) {
        byte result = suma(127, 8);
        System.out.println(result);
    }

    public static byte suma(int n, int m) {
        return (byte) (n + m);
    }
}
