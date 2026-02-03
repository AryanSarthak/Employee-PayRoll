package org.gevernova.employeepayroll.service;

import org.gevernova.employeepayroll.dto.request.EmployeePayrollRequest;
import org.gevernova.employeepayroll.dto.response.EmployeePayrollResponse;
import org.gevernova.employeepayroll.entity.Employee;
import org.gevernova.employeepayroll.repository.EmployeePayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    private final EmployeePayrollRepository repository;

    public EmployeePayrollServiceImpl(EmployeePayrollRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeePayrollResponse addEmployee(EmployeePayrollRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        Employee savedEmployee = repository.save(employee);
        return mapToResponse(savedEmployee);
    }

    @Override
    public EmployeePayrollResponse getEmployee(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        return mapToResponse(employee);
    }

    @Override
    public List<EmployeePayrollResponse> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeePayrollResponse updateEmployee(Long id, EmployeePayrollRequest request) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        Employee updatedEmployee = repository.save(employee);
        return mapToResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private EmployeePayrollResponse mapToResponse(Employee employee) {
        return new EmployeePayrollResponse(
                employee.getName(),
                employee.getDepartment()
        );
    }
}
