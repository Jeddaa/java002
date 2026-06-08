package com.tm30.heartrates;

import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public HeartRates(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void  setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public Integer getAgeInYears(){
        LocalDate today = LocalDate.now();
        if(birthDate == null) throw new IllegalStateException("Birth Date is not set");
        if(birthDate.isAfter(today)) throw new IllegalArgumentException("Birth Date cannot be in the future");
        return Period.between(birthDate, today).getYears();
    }
    public int getMaximumHeartRate(){
        return 220 - getAgeInYears();
    }
    public String getTargetHeartRate(){
        int maxi = getMaximumHeartRate();
        double lowEnd = 0.5 * maxi; //this is 50%
        double highEnd = 0.85 * maxi; //this is 80%
        return String.format("%.0f - %.0f", lowEnd, highEnd);
    }
}
