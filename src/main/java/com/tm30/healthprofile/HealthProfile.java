package com.tm30.healthprofile;

import java.time.LocalDate;
import java.time.Period;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private double height;
    private int weight;

    public HealthProfile(String firstName, String lastName, LocalDate birthDate, String gender, double height, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDate getBirthDate() {
        return this.birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public int getWeight(){
        return this.weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getAgeInYears(){
        LocalDate today = LocalDate.now();
        if(birthDate == null) throw new IllegalArgumentException("Birth Date is not set");
        if(birthDate.isAfter(today)) throw new IllegalArgumentException("Birth Date cannot be in the future");
        return Period.between(birthDate, today).getYears();
    }
    public int getMaximumHeartRate(){
        int age = getAgeInYears();
        return 220 - age;
    }
    public String getTargetHeartRate(){
        int maxi = getMaximumHeartRate();
        double lowEnd = 0.5 * maxi;
        double highEnd = 0.85 * maxi;
        return String.format("%.2f - %.2f", lowEnd, highEnd);
    }
    public double getBMI(){
        return (weight * 703) /(height * height);
    }
 // I don't know how to do this: It should also display the BMI values chart from Exercise 2.33.
}
