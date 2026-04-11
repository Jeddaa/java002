package com.tm30;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    // Heart Rate
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Please Enter Your FirstName");
//        String firstName = scanner.nextLine();
//        System.out.println("Please Enter Your LastName");
//        String lastName = scanner.nextLine();
//        System.out.println("Please enter your birth date YYYY-MM-DD");
//        String bDate = scanner.nextLine();
//        LocalDate birthDate = LocalDate.parse(bDate);
//
//        HeartRates person = new HeartRates(firstName, lastName, birthDate);
//
//        System.out.println("------- HeartRate Report");
//        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
//        System.out.println("Birth Date: " + person.getBirthDate());
//        System.out.println("Age: " + person.getAgeInYears());
//        System.out.println("Maximum HeartRate: " + person.getMaximumHeartRate());
//        System.out.println("Target HeartRate Range: " + person.getTargetHeartRate());
//    }

    // Health Profile
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your birth date YYYY-MM-DDD: ");
        String bDate = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(bDate);
        System.out.println("Please enter your Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Please enter your height in inches: ");
        double height = scanner.nextDouble();
        System.out.println("Please enter your weight in pounds: ");
        int weight = scanner.nextInt();

        HealthProfile person = new HealthProfile(firstName, lastName, birthDate, gender, height, weight);

        System.out.println("--------Health Profile-----------");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Age: " + person.getAgeInYears());
        System.out.println("Gender: " + person.getGender());
        System.out.println("Height: " + person.getHeight());
        System.out.println("Weight: " + person.getGender());
        System.out.println("Maximum HeartRate: " + person.getMaximumHeartRate());
        System.out.println("Target HeartRate Range: " + person.getTargetHeartRate());
        System.out.println("BMI: " + person.getBMI());
    }
}