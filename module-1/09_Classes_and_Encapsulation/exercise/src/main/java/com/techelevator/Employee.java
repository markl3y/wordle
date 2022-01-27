package com.techelevator;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    public Employee() {}

    //int employeeId, String firstName, String lastName, and double salary
    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }
    //Set
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //Get
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        fullName  = lastName + ", " + firstName;
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }


    //double called percent and returns void
    public void raiseSalary(double percent) {
        annualSalary = annualSalary + annualSalary * (percent / 100);
    }

}
