package co.uniquindio.analisis_algoritmos.recursivos;

public class NumPerfectos {

    public static void main(String[] args) {
        int n = 28;
        boolean isPerfecto = isNumPerfecto(n);
        System.out.println("El numero: "+n+" Es un numero perfecto: "+ isPerfecto);

        boolean isPerfectoReves = isNumPerfectoRevez(n);
        System.out.println("El numero: "+n+" Es un numero perfecto: "+ isPerfectoReves);
    }

    public static int sumarDivisores(int n, int i){
        // Caso base
        if(i == n){
            return 0;
        }
        if(n % i == 0){
            return i + sumarDivisores(n, i+1);
        }
        else{
            return sumarDivisores(n, i+1);
        }
    }

    public static int sumarDivisoresReves(int n, int i){
        if(i == 0){
            return 0;
        }
        if(n % i == 0){
            return i + sumarDivisoresReves(n, i-1);
        }
        else{
            return sumarDivisoresReves(n, i-1);
        }
    }

    public static boolean isNumPerfecto(int n){
        return n == sumarDivisores(n, 1);
    }

    public static boolean isNumPerfectoRevez(int n){
        return n == sumarDivisoresReves(n, n-1);
    }

}
