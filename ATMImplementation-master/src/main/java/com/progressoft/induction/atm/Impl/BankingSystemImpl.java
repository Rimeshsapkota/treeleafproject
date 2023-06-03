package com.progressoft.induction.atm.Impl;

import com.progressoft.induction.atm.BankingSystem;
import com.progressoft.induction.atm.Banknote;
import com.progressoft.induction.atm.exceptions.InsufficientFundsException;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class BankingSystemImpl implements BankingSystem {
   Map<String, BigDecimal> accountBalanceMap = new HashMap<String, BigDecimal>();
   EnumMap<Banknote,Integer> atmCashMap = new EnumMap<>(Banknote.class);

    public BankingSystemImpl() {
        atmCashMap.put(Banknote.FIFTY_JOD,10);
        atmCashMap.put(Banknote.TWENTY_JOD,20);
        atmCashMap.put(Banknote.TEN_JOD,100);
        atmCashMap.put(Banknote.FIVE_JOD,100);

        accountBalanceMap.put("123456789", BigDecimal.valueOf(1000.0));
        accountBalanceMap.put("111111111", BigDecimal.valueOf(1000.0));
        accountBalanceMap.put("222222222", BigDecimal.valueOf(1000.0));
        accountBalanceMap.put("333333333", BigDecimal.valueOf(1000.0));
        accountBalanceMap.put("444444444", BigDecimal.valueOf(1000.0));
    }

    public BigDecimal sumOfMoneyInAtm() {
        BigDecimal sum = BigDecimal.ZERO;

        for (Map.Entry<Banknote, Integer> entry : atmCashMap.entrySet()) {
            Banknote banknote = entry.getKey();
            Integer quantity = entry.getValue();

            BigDecimal banknoteValue = banknote.getValue();
            BigDecimal totalValue = banknoteValue.multiply(BigDecimal.valueOf(quantity));

            sum = sum.add(totalValue);
        }

        return sum;
    }



    @Override
    public BigDecimal getAccountBalance(String accountNumber) {
        BigDecimal accountBalance = accountBalanceMap.get(accountNumber);
         if (accountBalance==null){
             throw new IllegalArgumentException("Invalid account number");
         }
        return  accountBalance;
    }

    @Override
    public void debitAccount(String accountNumber, BigDecimal amount) {
        BigDecimal accountBalance = accountBalanceMap.get(accountNumber);
        if (accountBalance == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        BigDecimal newBalance = accountBalance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }

        System.out.println(accountBalanceMap.put(accountNumber, newBalance));
    }
}
