package com.tm30.bankapp;

import lombok.Getter;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class BankApp {
    private String firstName;
    private String lastName;
    private final LocalDate dateOfBirth;
    private final LocalDate createdAt;
    private String address;
    private String email;
    private String phoneNumber;
    private final String bvn;
    private final String nin;
    private double balance;
    private final long accountNumber;

    public BankApp(String firstName, String lastName, String phoneNumber, String email,
                   String address, String bvn, String nin, String dob) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email provided. Email must contain @");
        }
        if (!phoneNumber.startsWith("234"))
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
        return String.format("""
                        Your Bank account has been created! Your profile is as follows:
                        Name: %s %s
                        Date Of Birth: %s
                        Phone Number: %s
                        Email Address: %s
                        House Address: %s
                        BVN: %s
                        NIN: %s
                        Account Number: %d
                        Current Balance: %.2f""",
                firstName, lastName, dateOfBirth, phoneNumber, email, address, bvn, nin, accountNumber, balance);
    }
    public String updateProfile(String firstName, String lastName, String email, String phoneNumber, String address){
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email provided. Email must contain @");
        }
        if(!phoneNumber.startsWith("234"))
            throw new IllegalArgumentException("Invalid phone number provided. Phone number must start with 234");
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        return String.format("""
                        Your updated bank profile is as follows:
                        Name: %s %s
                        Date Of Birth: %s
                        Phone Number: %s
                        Email Address: %s
                        House Address: %s
                        BVN: %s
                        NIN: %s
                        Account Number: %d
                        Current Balance: %.2f""",
                this.firstName, this.lastName, dateOfBirth, this.phoneNumber, this.email, this.address, bvn, nin, accountNumber, balance);
    }
    /**
     * @param amount to credit
     * @desc to credit an account
     * @return a statement containing the account balance
     */
    public String creditAccount(double amount){
        if(amount > 0) balance += amount;
        return String.format("Your credit was successful for account %d. Current account balance if %.2f",
                accountNumber, getBalance());
    }

    /**
     * @param amount to debit
     * @desc to debit an account
     * @return a statement containing the account balance
     */
    public String debitAccount(double amount){
        if(amount > 0) balance -= amount;
        return String.format("Your debit was successful for account %d. Your current account balance is %.2f",
                accountNumber, getBalance());
    }
}
