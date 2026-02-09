package org.gevernova.employeepayroll.service;

import lombok.extern.slf4j.Slf4j;
import org.gevernova.employeepayroll.dto.request.EmployeePayrollRequest;
import org.gevernova.employeepayroll.dto.response.EmployeePayrollResponse;
import org.gevernova.employeepayroll.entity.Employee;
import org.gevernova.employeepayroll.repository.EmployeePayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    private final EmployeePayrollRepository repository;

    public EmployeePayrollServiceImpl(EmployeePayrollRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeePayrollResponse addEmployee(EmployeePayrollRequest request) {
        log.info("Adding employee with name: {}, department: {}", request.getName(), request.getDepartment());

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        Employee savedEmployee = repository.save(employee);

        log.info("Employee added successfully with id: {}", savedEmployee.getId());

        return mapToResponse(savedEmployee);
    }

    @Override
    public EmployeePayrollResponse getEmployee(Long id) {
        log.info("Fetching employee with id: {}", id);

        Employee employee = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee not found with id: {}", id);
                    return new RuntimeException("Employee not found with id: " + id);
                });

        log.info("Employee fetched successfully with id: {}", id);

        return mapToResponse(employee);
    }

    @Override
    public List<EmployeePayrollResponse> getAllEmployees() {
        log.info("Fetching all employees");

        List<EmployeePayrollResponse> employees = repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        log.info("Total employees fetched: {}", employees.size());

        return employees;
    }

    @Override
    public EmployeePayrollResponse updateEmployee(Long id, EmployeePayrollRequest request) {
        log.info("Updating employee with id: {}", id);

        Employee employee = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee not found for update with id: {}", id);
                    return new RuntimeException("Employee not found with id: " + id);
                });

        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        Employee updatedEmployee = repository.save(employee);

        log.info("Employee updated successfully with id: {}", id);

        return mapToResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id: {}", id);

        if (!repository.existsById(id)) {
            log.error("Employee not found for deletion with id: {}", id);
            throw new RuntimeException("Employee not found with id: " + id);
        }

        repository.deleteById(id);

        log.info("Employee deleted successfully with id: {}", id);
    }

    private EmployeePayrollResponse mapToResponse(Employee employee) {
        return new EmployeePayrollResponse(
                employee.getName(),
                employee.getDepartment()
        );
    }
}
