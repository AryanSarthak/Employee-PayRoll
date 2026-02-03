package org.gevernova.employeepayroll.service;

import org.gevernova.employeepayroll.dto.request.EmployeePayrollRequest;
import org.gevernova.employeepayroll.dto.response.EmployeePayrollResponse;

import java.util.List;

public interface EmployeePayrollService {

    // Adds a new employee to the system
    EmployeePayrollResponse addEmployee(EmployeePayrollRequest request);

    // Retrieves employee details by employee ID
    EmployeePayrollResponse getEmployee(Long id);

    // Retrieves all employees from the system
    List<EmployeePayrollResponse> getAllEmployees();

    // Updates existing employee details using employee ID
    EmployeePayrollResponse updateEmployee(Long id, EmployeePayrollRequest request);

    // Deletes an employee using employee ID
    void deleteEmployee(Long id);
}
