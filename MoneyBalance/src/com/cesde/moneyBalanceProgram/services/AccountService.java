package com.cesde.moneybalanceprogram.services;

import com.cesde.moneybalanceprogram.entities.Account;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountService {

    static boolean exit = true;
    static Scanner read = new Scanner(System.in);

    static Account account = new Account();
    int incoCounter = 0, egresCounter = 0;

    //Metodo para iniciar el programa
    public void start(){
        System.out.println();
        System.out.println("*************** BIEVENIDO ***************");
        System.out.println();

        do {
            System.out.println("Ingrese la opción deseada");
            System.out.println("1. Ingreso");
            System.out.println("2. Egreso");
            System.out.println("3. Balance actual");
            System.out.println("4. Salir");
            String opc = read.next();

            switch (opc){
                case "1":
                    income();
                    incoCounter++;
                    exit = true;
                    break;

                case "2":
                    egress();
                    egresCounter++;
                    exit = true;
                    break;

                case "3":
                    System.out.println("El balance actual de la cuenta es: " + balance());;
                    exit = true;
                    break;

                case "4":
                    System.out.println(" ************ PROGRAMA TERMINADO ************ ");
                    exit = false;
                    break;

                default:
                    System.out.println("Opción seleccionada no válida");
                    exit = true;
                    break;
            }


        }while(exit);

    }

    public void income(){
        Double money;
        ArrayList<Double> incomes = account.getIncome();
        exit = true;
        do {
            try {
                System.out.println("Ingrese el valor a ingresar a la cuenta");
                money = read.nextDouble();
                exit = false;
                read.skip("\n");
            } catch (InputMismatchException e){
                System.out.println("Solo se admiten valores numericos");
                money = 0.0;
                exit = true;
            }
        }while (exit);

        incomes.add(money);
        account.setIncome(incomes);
    }

    public void egress(){
        Double money;
        ArrayList<Double> egresses = account.getEgress();
        exit = true;
        do {
            try {
                System.out.println("Ingrese el valor del egreso a la cuenta");
                money = read.nextDouble();
                exit = false;
                read.skip("\n");
            } catch (InputMismatchException e){
                System.out.println("Solo se admiten valores numericos");
                money = 0.0;
                exit = true;
            }
        }while (exit);

        egresses.add(money);
        account.setEgress(egresses);
    }

    public Double balance(){
        Double balanceFinal = 0.0;
        Double sumIncome = 0.0;
        Double sumEgress = 0.0;

        for (Double mon: account.getIncome()) {
            sumIncome += mon;
        }

        for (Double mon: account.getEgress()) {
            sumEgress += mon;
        }

        System.out.println("Se realizaron " + incoCounter +  " ingresos. Totalidad de los ingresos: " + sumIncome);
        System.out.println("Se realizaron " + egresCounter +  " egresos. Totalidad de los egresos: " + sumEgress);

        return sumIncome - sumEgress;
    }

}
