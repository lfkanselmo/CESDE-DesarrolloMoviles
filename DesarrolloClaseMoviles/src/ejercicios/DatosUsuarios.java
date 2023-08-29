package ejercicios;

/*
 * Crear un programa que almacene los datos de usuarios,
 * que imprima los datos y permita almacenar nuevos datos.
 * los datos a almacenar seran: nombre, edad, correo
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class DatosUsuarios {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String[]> usuarios = new ArrayList<>();
        boolean exit = true;

        System.out.println("****** BIEVENIDO ******");

        do {
            System.out.println();
            System.out.println("Ingrese la opción deseada: ");
            System.out.println("1. Nuevo usuario");
            System.out.println("2. Datos de usuario especifico");
            System.out.println("3. Mostrar los datos de todos los usuarios");
            System.out.println("4. Salir");
            String opc = read.next();
            read.skip("\n");

            switch (opc) {
                case "1":
                    System.out.println();
                    System.out.println("Ingrese el nombre del nuevo usuario");
                    String name = read.nextLine();
                    System.out.println();
                    System.out.println("Ingrese la edad del nuevo usuario");
                    String age = read.nextLine();
                    System.out.println();
                    System.out.println("Ingrese el email del nuevo usuario");
                    String email = read.nextLine();
                    System.out.println();

                    String[] usuario = {name, age, email};

                    usuarios.add(usuario);

                    break;


                case "2":
                    System.out.println("ingrese el nombre del usuario del que desea los datos: ");
                    String nameUser = read.nextLine();
                    boolean encontrado = false;
                    String[] userfound = new String[3];

                    for (String[] user : usuarios) {
                        if (user[0].equalsIgnoreCase(nameUser)) {
                            encontrado = true;
                            userfound = user;
                            break;
                        }


                    }

                    if (encontrado) {
                        System.out.println("[ Nombre: " + userfound[0] + ", Edad:" + userfound[1] + ", Email:" + userfound[2] + " ]");
                        System.out.println();
                    } else {
                        System.out.println("El usario buscado no existe");
                    }

                    break;

                case "3":
                    int i = 1;
                    for (String[] user : usuarios) {
                        System.out.println("Usuario " + i + ": " + "[ Nombre: " + user[0] + ", Edad:" + user[1] + ", Email:" + user[2] + " ]");
                        System.out.println();
                        i++;
                    }

                    break;

                case "4":
                    System.out.println("****** TERMINADO ******");
                    exit = false;
                    break;
                default:
                    System.out.println("Opción seleccionada no válida");
                    break;
            }
        } while (exit);
    }
}
