package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class FavoriteThings {
    static Scanner read = new Scanner(System.in);
    static String[] book;
    static ArrayList<String[]> library = new ArrayList<>();

    public static void main(String[] args) {
        start();
        show();
    }

    //metodo para iniciar
    public static void start() {
        boolean end = true;
        int n = 1;
        int limit = 3;

        while (end || n < (limit + 1)) {
            book = new String[2];
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("Ingrese libro favorito");
            book[0] = read.nextLine();
            System.out.println();
            System.out.println("Ingrese autor del libro");
            book[1] = read.nextLine();

            library.add(book);
            n++;

            if (n > limit) {
                System.out.println();
                System.out.println("Si desea ingresar otro libro ingrese S");
                String opc = read.next();
                read.skip("\n");
                if (opc.equalsIgnoreCase("s")) {
                    end = true;
                } else {
                    System.out.println();
                    System.out.println("********** INGRESO TERMINADO **********");
                    System.out.println();
                    end = false;
                }
            }
        }
    }

    //metodo para imprimir la libreria
    public static void show() {
        System.out.println();
        int i = 1;
        System.out.println();
        System.out.println("----------------- TODOS LOS LIBROS -----------------");
        System.out.println();
        for (String[] bk : library) {
            System.out.println("Libro " + i + ": [ Titulo: " + bk[0] + ",  Autor: " + bk[1] + " ]");
            i++;
        }
    }
}
