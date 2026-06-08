package com.tm30.bankapp;

import lombok.Getter;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class BankApp {
    public BankAccount openAccount(User user) {
        String accountNumber = String.valueOf(ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L));
        return new BankAccount(user, accountNumber);
    }
}
