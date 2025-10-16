package co.uniquindio.analisis_algoritmos.iterativos;

public class EAN8 {

    public static void main(String[] args) {
        String code = "65839522";
        boolean isEAN8 = isEAN8(code);

        System.out.println("El numero: "+code+" "+"Es EAN8?: "+isEAN8);
    }

    /**
     *Se solicita escribir un algoritmo para informar si un código corresponde a un código de barras en formato
     * EAN-8. Cada código de barras en formato EAN-8 contiene 8 dígitos. Todo código de barras tiene un código de
       comprobación (el último dígito). El dígito de comprobación para el código “65839522”, es 2. Para verificar si el
       código de barras en EAN-8 es correcto, se debe realizar lo siguiente:
     * - Se inicia por la derecha (se omite el código de control) y se suman los dígitos individuales,
         multiplicados por un factor (3 ó 1).
     * - El código de barras es correcto, si se suma el dígito de control al resultado de la operación anterior.
         Esta sumatoria debe ser múltiplo de 10. Por ejemplo, la suma da 88+2=90. Si la suma es múltiplo de
          10, entonces el dígito de control debe ser 0.
     * @param code
     * @return
     */
    private static boolean isEAN8(String code){

        // Validamos que la cadena tenga 8 digitos
        if(code.length() != 8){
            return false;
        }

        int sum = 0;
        int num;
        // Recorremos el codigo de derecha a izquierda desde el penultimo digitio
        // Calculamos el resultado de su suma con el producto (3 ó 1)
        for(int i=code.length()-2; i>=0; i--){
            num = code.charAt(i) - '0';
            if(i % 2 == 0){
                sum += num * 3;
            }
            else{
                sum += num;
            }
        }

        // Obtenemos el ultimo digito (digito de verificacion)
        int last = code.charAt(code.length()-1) - '0';
        // Validamos que se cumpla el EAN8
        // Se cumple si la suma de el codigo de verificacion y la suma con factores calculadas es divisible por 10
        return (sum + last) % 10 == 0;

    }
}
