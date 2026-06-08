package com.tm30.bankapp;

import lombok.Getter;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class BankAccount {
    private final User owner;
    private double balance;
    private final String accountNumber;

    public BankAccount (User user, String accountNumber) {
        this.accountNumber = accountNumber;
        this.owner = user;
        this.balance = 0.0;
    }

    /**
     * @param amount to credit
     * @desc to credit an account
     * @return a statement containing the account balance
     */
    public String creditAccount(double amount){
        if(amount > 0) balance += amount;
        return String.format("Your credit was successful for account %s. Current account balance if %.2f",
                accountNumber, getBalance());
    }

    /**
     * @param amount to debit
     * @desc to debit an account
     * @return a statement containing the account balance
     */
    public String debitAccount(double amount){
        if(amount > 0) balance -= amount;
        return String.format("Your debit was successful for account %s. Your current account balance is %.2f",
                accountNumber, getBalance());
    }
}
