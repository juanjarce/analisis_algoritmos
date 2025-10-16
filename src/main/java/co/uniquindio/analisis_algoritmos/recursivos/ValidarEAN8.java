package co.uniquindio.analisis_algoritmos.recursivos;

public class ValidarEAN8 {
    public static void main(String[] args) {
        String code = "65839522";
        boolean isEAN8 = isEAN8(code);

        System.out.println("El numero: "+code+" "+"Es EAN8?: "+isEAN8);
    }

    /**
     * Se solicita crear los métodos recursivos para informar los códigos de barras en formato EAN-8
       que son correctos. Cada código de barras en formato EAN-8 contiene 8 dígitos y se trabaja como
       un String. Todo código de barras tiene un código de comprobación (el último dígito). El dígito de
       comprobación para el código “65839522”, es 2. Para verificar si el código de barras en EAN-8
       es correcto, se debe realizar lo siguiente:
     * Se inicia por la derecha (se omite el código de control) y se suman los dígitos individuales,
       multiplicados por un factor (3 ó 1). Por ejemplo, para el código EAN-8: "65839522”, la
       operación a realizar es: 2 * 3 + 5 * 1 + 9 * 3 + 3 * 1 + 8 * 3 + 5 * 1 + 6 * 3 = 88
     * El código de barras es correcto, si se suma el dígito de control al resultado de la operación
       anterior. Esta sumatoria debe ser múltiplo de 10. Por ejemplo, la suma da 88+2=90. Si la
       suma es múltiplo de 10, entonces el dígito de control debe ser 0.
     */
    public static int sumarEAN8(String code, int i){
        // Caso base: limite del código
        if(i >= code.length() - 1){
            return 0;
        }
        // Recursión: se recorre el codigo y se hace la suma del producto (derecha a izquierda)
        int digito = code.charAt(i) - '0';
        if(i % 2 == 0){
            return sumarEAN8(code, i+1) + (digito * 3);
        }
        else{
            return sumarEAN8(code, i+1) + digito;
        }
    }

    /**
     * Función para validar que el codigo sea un EAN8
     */
    public static boolean isEAN8(String code){
        int lastDigit = code.charAt(code.length()-1) - '0';
        return (sumarEAN8(code, 0)  + lastDigit) % 10 == 0;
    }
}
