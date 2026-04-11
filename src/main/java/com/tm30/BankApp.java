package com.tm30;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class BankApp {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate createdAt;
    private String address;
    private String email;
    private String phoneNumber;
    private String bvn;
    private String nin;
    private double balance;
    private long accountNumber;

    public BankApp(String firstName, String lastName, String phoneNumber, String email,
                   String address, String bvn, String nin, String dob) {
        if (!email.contains("@") || email == null) {
            throw new IllegalArgumentException("Invalid email provided. Email must contain @");
        }
        if (!phoneNumber.startsWith("234") || phoneNumber == null)
            throw new IllegalArgumentException("Invalid phone number provided. Phone number must start with 234");
        if (bvn.length() != 12) throw new IllegalArgumentException("Bvn must be 12 digits");
        if (nin.length() != 15) throw new IllegalArgumentException("Nin must be 15 digits");
        if (dob == null || LocalDate.parse(dob).isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Date of birth cannot be in the future!");

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bvn = bvn;
        this.nin = nin;
        this.dateOfBirth = LocalDate.parse(dob);
        this.createdAt = LocalDate.now();
        this.balance = 0;
//        this.accountNumber = new Random().nextInt(100000000);
        this.accountNumber = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
    }
    public String createProfile(){
//        this.created_at = LocalDate.now();
        return String.format("Your Bank account has been created! Your profile is as follows:\n" +
                        "Name: %s %s\nDate Of Birth: %s\nPhone Number: %s\nEmail Address: %s\nHouse Address: %s" +
                        "\nBVN: %s\nNIN: %s\nAccount Number: %d\nCurrent Balance: %.2f",
                firstName, lastName, dateOfBirth, phoneNumber, email, address, bvn, nin, accountNumber, balance);
    }
    public String updateProfile(String firstName, String lastName, String email, String phoneNumber){
        if (!email.contains("@")  || email == null) {
            throw new IllegalArgumentException("Invalid email provided. Email must contain @");
        }
        if(!phoneNumber.startsWith("234") || phoneNumber == null)
            throw new IllegalArgumentException("Invalid phone number provided. Phone number must start with 234");
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        return String.format("Your updated bank profile is as follows:\n" +
                        "Name: %s %s\nDate Of Birth: %s\nPhone Number: %s\nEmail Address: %s\nHouse Address: %s" +
                        "\nBVN: %s\nNIN: %s\nAccount Number: %d\nCurrent Balance: %.2f",
                this.firstName, this.lastName, dateOfBirth, this.phoneNumber, this.email, address, bvn, nin, accountNumber, balance);
    }
    /**
     * @param amount
     * @desc to credit an account
     * @return a statement containing the account balance
     */
    public String creditAccount(double amount){
        if(amount > 0) balance += amount;
        return String.format("Your credit was successful for account %d. Current account balance if %.2f",
                accountNumber, getBalance());
    }

    /**
     * @param amount
     * @desc to debit an account
     * @return a statement containing the account balance
     */
    public String debitAccount(double amount){
        if(amount > 0) balance -= amount;
        return String.format("Your debit was successful for account %d. Your current account balance is %.2f",
                accountNumber, getBalance());
    }
}
