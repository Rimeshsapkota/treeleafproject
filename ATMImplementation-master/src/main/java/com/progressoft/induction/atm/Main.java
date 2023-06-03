package com.progressoft.induction.atm;

import com.progressoft.induction.atm.Impl.ATMImpl;
import com.progressoft.induction.atm.Impl.BankingSystemImpl;
import com.progressoft.induction.atm.exceptions.AccountNotFoundException;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String args[]){
        ATM atm = new ATMImpl();
        BankingSystemImpl bankingSystem = new BankingSystemImpl();
        BigDecimal bigDecimal= bankingSystem.getAccountBalance("123456789");
        System.out.println(bankingSystem.sumOfMoneyInAtm());
       // your code here
    }
}
