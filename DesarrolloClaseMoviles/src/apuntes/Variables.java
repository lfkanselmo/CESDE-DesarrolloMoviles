package apuntes;

public class Variables {
    public static void main(String[] args) {

        //Tipos de datos: String, char, byte, boolean, int, float, double

        String nombre = "Pepito";  //Declarar e inicializar al mismo tiempo
        int id = 1012294210;

        /*
        Scope o ambito de las variables corresponde a si
         esta puede ser alcanzada por todas las estructuras que componen la clase
        o si solo funciona para una estructura
        */

        //Scope global
        String global = "Soy Global";

        if (global.equals("Soy Global")){
            System.out.println("Es una variable global");
            //Scope local (Solo existe dentro de la estructura condicional IF)
            String Local = "Yo no soy global";
        } else {
            System.out.println("No es una variable global");
        }

        System.out.println(global);

        //Las variables del mismo tipo se pueden castear sin perdida de información
        //Las que son de distinto tipo tienen perdida de información

        byte numByte = 120;
        short numShort = (short) numByte;

        System.out.println(numShort);     //debería imprimir 120

        //Parse: el parseo se da entre String y datos númericos

        int numInt = 1234567;

        //Parseamos el numero a String y lo guardamos en una variable de tipo cadena texto
        //usamos el objeto Integer (wrap de int) para parsear con su metodo toString()
        String numIntConvertido = Integer.toString(numInt);

        //imprimimos el String que almacena el número parseado
        System.out.println(numIntConvertido);


        String numString = "12.4";

        //Parseamos un String que contiene un numero con punto flotante para convertirlo en un numero Double
        //Usamos el objeto Double (wrap de double) para parsear con su metodo parseDouble()
        double numDouble = Double.parseDouble(numString);

    }
}
