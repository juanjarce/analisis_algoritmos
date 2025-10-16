package co.uniquindio.analisis_algoritmos.recursivos;

public class MenorElemArrego {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 6, 7, 2, 9};

        int menor = devolverMenor(arr, arr[0], 0);
        System.out.println("El menor elemento del arreglo es: " + menor);

        int menorReves = devolverMenorReves(arr, arr[0], arr.length -1);
        System.out.println("El menor elemento del arreglo es (Recorrido al revés): " + menorReves);
    }

    // Función recursiva para devolver el elemento menor en un arreglo de enteros
    public static int devolverMenor(int[] arr, int menor, int i){
        // caso base: se termina de recorrer el arreglo
        if(i == arr.length){
            return menor;
        }
        // Recursividad
        if(arr[i]<menor){
            return devolverMenor(arr, arr[i], i+1);
        }
        else{
            return devolverMenor(arr, menor, i+1);
        }
    }

    public static int devolverMenorReves(int[] arr, int menor, int n){
        // Caso Base: limite del arreglo
        if(n < 0){
            return menor;
        }
        // Recursión: se recorre el arreglo para encontrar el menor
        if(arr[n] < menor){
            return devolverMenorReves(arr, arr[n], n-1);
        }
        else{
            return devolverMenorReves(arr, menor, n-1);
        }
    }

}
