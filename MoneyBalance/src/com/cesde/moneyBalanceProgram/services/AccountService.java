package com.cesde.moneybalanceprogram.services;

import com.cesde.moneybalanceprogram.entities.Account;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountService {

    static boolean exit = true;
    static Scanner read = new Scanner(System.in);

    static Account account = new Account();
    static String[] files;
    static ArrayList<String[]> statement = new ArrayList<>();
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
            System.out.println("4. Estracto de la cuenta");
            System.out.println("5. Salir");
            String opc = read.next();

            switch (opc){
                case "1":
                    transation("income");
                    incoCounter++;
                    exit = true;
                    break;

                case "2":
                    transation("egress");
                    egresCounter++;
                    exit = true;
                    break;

                case "3":
                    System.out.println("El balance actual de la cuenta es: " + balance());;
                    exit = true;
                    break;

                case "4":
                    inform();
                    break;

                case "5":
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

    public void transation(String option){
        Double money;
        files = new String[3];
        ArrayList<Double> transactions = new ArrayList<>();
        if (option.equals("income")){
            transactions = account.getIncome();
        } else if (option.equals("egress")){
            transactions = account.getEgress();
        }

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

        LocalDateTime times = LocalDateTime.now();

        String date = "------> [ "
                + String.valueOf(times.getDayOfMonth())
                + String.valueOf(times.getMonthValue())
                + String.valueOf(times.getYear())
                + " --- "
                + String.valueOf(times.getHour())
                + String.valueOf(times.getMinute())
                + String.valueOf(times.getSecond()) + " ]";

        files[0] = date;
        files[1] = option;
        files[2] = money.toString();

        statement.add(files);
        transactions.add(money);

        if(option.equals("income")){
            account.setIncome(transactions);
        } else if(option.equals("egress")){
            account.setEgress(transactions);
        }
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

    public void inform(){
        for (String[] r : statement){
            System.out.println("-----> [ Fecha: " + r[0] + ", Transacción: " + r[1] + ", Valor: " + r[2] + " ]" );
        }
    }
}
