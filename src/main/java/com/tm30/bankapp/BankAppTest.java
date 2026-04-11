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

        BankApp user1 = new BankApp(firstName, lastName, phoneNumber, email, address, bvn, nin, dob );
        System.out.println(user1.createProfile());
        System.out.printf("Your account Number is: %d\n", user1.getAccountNumber());
        System.out.println(user1.creditAccount(1000));
        System.out.printf("Your current account balance is: %f\n", user1.getBalance());
        System.out.println(user1.debitAccount(100));
        System.out.printf("Your current account balance is: %f\n", user1.getBalance());
        System.out.printf("%s %s\n", user1.getFirstName(), user1.getLastName());
        System.out.println("@@@@@@@@@@@@@@ Testing the updating profile @@@@@@@@@@@@@");
        System.out.println(user1.updateProfile("moyosore", "oduwole", "test@gmail.com",
                "23409121232", "ikotun"));

    }
}
