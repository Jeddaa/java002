package com.tm30.bankapp;

import java.util.Scanner;

public class BankAppTest {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your phone number starting with 234");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter your email address");
        String email = scanner.nextLine();
        System.out.println("Please enter your house address");
        String address = scanner.nextLine();
        System.out.println("Please enter your 12 digit BVN: ");
        String bvn = scanner.nextLine();
        System.out.println("Please enter your NIN: ");
        String nin = scanner.nextLine();
        System.out.println("Please enter your date of birth in YYYY-MM-DD: ");
        String dob = scanner.nextLine();

        User customer = new User(firstName, lastName, phoneNumber, email, address, bvn, nin, dob );
        BankApp bank = new BankApp();
        BankAccount user1 = bank.openAccount(customer);

        System.out.printf("Your account Number is: %s\n", user1.getAccountNumber());
        System.out.println(user1.creditAccount(1000));
        System.out.printf("Your current account balance is: %f\n", user1.getBalance());
        System.out.println(user1.debitAccount(100));
        System.out.printf("Your current account balance is: %f\n", user1.getBalance());
        System.out.printf("%s %s\n", user1.getOwner().getFirstName(), user1.getOwner().getLastName());
    }
}
