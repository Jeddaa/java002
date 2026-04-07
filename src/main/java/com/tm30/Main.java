package com.tm30;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter Your FirstName");
        String firstName = scanner.nextLine();
        System.out.println("Please Enter Your LastName");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your birth date YYYY-MM-DD");
        String bDate = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(bDate);

        HeartRates person = new HeartRates(firstName, lastName, birthDate);

        System.out.println("------- HeartRate Report");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Birth Date: " + person.getBirthDate());
        System.out.println("Age: " + person.getAgeInYears());
        System.out.println("Maximum HeartRate: " + person.getMaximumHeartRate());
        System.out.println("Target HeartRate Range: " + person.getTargetHeartRate());
    }
}