package org.gevernova.employeepayroll.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class EmployeePayrollRequest {

    @NotBlank(message = "Name cannot be empty") // Validates name is not null or blank
    private String name;

    @NotNull(message = "Salary is required") // Salary must be provided
    @Positive(message = "Salary must be greater than zero") // Salary must be positive
    private BigDecimal salary;

    @NotBlank(message = "Department cannot be empty") // Validates department
    private String department;

    // Default constructor
    public EmployeePayrollRequest() {
    }

    // Parameterized constructor
    public EmployeePayrollRequest(String name, BigDecimal salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
