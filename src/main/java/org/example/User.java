package org.example;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {
    private String firstName;
    private String lastName;
    private String individualTaxNumber;
    private String cityOfResidence;

    public User(String firstName, String lastName, String individualTaxNumber, String cityOfResidence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.individualTaxNumber = individualTaxNumber;
        this.cityOfResidence = cityOfResidence;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIndividualTaxNumber() {
        return individualTaxNumber;
    }

    public void setIndividualTaxNumber(String individualTaxNumber) {
        this.individualTaxNumber = individualTaxNumber;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", individualTaxNumber='" + individualTaxNumber + '\'' +
                ", cityOfResidence='" + cityOfResidence + '\'' +
                '}';
    }


    @Override
    public int compareTo(User o) {
        return this.individualTaxNumber.compareTo(o.individualTaxNumber);
    }
}
