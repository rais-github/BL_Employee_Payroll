package com.example.payrollApp.EmployeePayrollApplication.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class EmployeeDto {

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Role is mandatory")
    private String role;

    @Min(value = 1, message = "Salary must be greater than 0")
    private double salary;

    @PastOrPresent(message = "Date of joining must be in the past or present")
    private LocalDate dateOfJoining;

    @Min(value = 0, message = "Leave balance cannot be negative")
    private int leaveBalance;

    @NotEmpty(message = "Department is mandatory")
    private String department;

    @Email(message = "Email must be valid")
    @NotEmpty(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @NotEmpty(message = "Phone number is mandatory")
    private String phoneNumber;

    @NotEmpty(message = "Address is mandatory")
    private String address;

    // Getters and Setters
    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }


    public EmployeeDto() {}

    public EmployeeDto(String name, String role, double salary, LocalDate dateOfJoining, int leaveBalance, String department, String email, String phoneNumber, String address) {
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.leaveBalance = leaveBalance;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
