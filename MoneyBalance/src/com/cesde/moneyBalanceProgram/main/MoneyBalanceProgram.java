package com.cesde.moneybalanceprogram.main;

import com.cesde.moneybalanceprogram.services.AccountService;

public class MoneyBalanceProgram {

    public static void main(String[] args) {
        AccountService program = new AccountService();
        program.start();
    }


}
