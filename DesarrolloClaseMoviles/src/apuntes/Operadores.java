package apuntes;

public class Operadores {
    public static void main(String[] args) {
        int sumaInterna = 4 + 5;

        int operacion = (4+3*5)*((10-2)/2)/4+3;

        System.out.println(sumaInterna);
        System.out.println(operacion);

        boolean compNum = 4>5;
        boolean comComp = 3>2 || 4!=5;
        boolean comComp2 = false && true;

        System.out.println(compNum);
        System.out.println(comComp);
        System.out.println(comComp2);
    }
}
