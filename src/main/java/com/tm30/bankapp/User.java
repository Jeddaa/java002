package com.tm30.bankapp;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class User {
    private String firstName;
    private String lastName;
    private final LocalDate dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;
    private final String bvn;
    private final String nin;

    public User(String firstName, String lastName, String phoneNumber, String email,
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
    }
}