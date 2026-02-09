package org.gevernova.employeepayroll.service;

import lombok.extern.slf4j.Slf4j;
import org.gevernova.employeepayroll.dto.request.EmployeePayrollRequest;
import org.gevernova.employeepayroll.dto.response.EmployeePayrollResponse;
import org.gevernova.employeepayroll.entity.Employee;
import org.gevernova.employeepayroll.exception.EmployeeNotFoundException;
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

        log.info("Adding employee {}", request.getName());

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        Employee saved = repository.save(employee);

        return mapToResponse(saved);
    }

    @Override
    public EmployeePayrollResponse getEmployee(Long id) {

        log.info("Fetching employee {}", id);

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));

        return mapToResponse(employee);
    }

    @Override
    public List<EmployeePayrollResponse> getAllEmployees() {

        log.info("Fetching all employees");

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeePayrollResponse updateEmployee(Long id, EmployeePayrollRequest request) {

        log.info("Updating employee {}", id);

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));

        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());

        Employee updated = repository.save(employee);

        return mapToResponse(updated);
    }

    @Override
    public void deleteEmployee(Long id) {

        log.info("Deleting employee {}", id);

        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id " + id);
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
