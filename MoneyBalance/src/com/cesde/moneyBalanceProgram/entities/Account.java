package com.cesde.moneybalanceprogram.entities;

import java.util.ArrayList;

public class Account {
    private String owner;
    private ArrayList<Double> income = new ArrayList<>();
    private ArrayList<Double> egress = new ArrayList<>();
    private Integer balance;

    public Account() {
    }

    public Account(String owner, ArrayList<Double> income, ArrayList<Double> egress, Integer balance) {
        this.owner = owner;
        this.income = income;
        this.egress = egress;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<Double> getIncome() {
        return income;
    }

    public void setIncome(ArrayList<Double> income) {
        this.income = income;
    }

    public ArrayList<Double> getEgress() {
        return egress;
    }

    public void setEgress(ArrayList<Double> egress) {
        this.egress = egress;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Cuenta --> {" +
                "Titular = '" + owner + '\'' +
                ", Balance = " + balance +
                '}';
    }
}
