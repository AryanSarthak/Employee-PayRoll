package org.gevernova.employeepayroll.dto.response;

public class EmployeePayrollResponse {

    private  String name;
    private String department;

    public EmployeePayrollResponse() {
    }
    public EmployeePayrollResponse(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
