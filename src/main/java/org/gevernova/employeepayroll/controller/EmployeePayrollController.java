package org.gevernova.employeepayroll.controller;

import org.gevernova.employeepayroll.dto.request.EmployeePayrollRequest;
import org.gevernova.employeepayroll.dto.response.EmployeePayrollResponse;
import org.gevernova.employeepayroll.service.EmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeePayrollController {

    private final EmployeePayrollService service;

    public EmployeePayrollController(EmployeePayrollService service) {
        this.service = service;
    }

    // Add a new employee
    @PostMapping("/save")
    public ResponseEntity<EmployeePayrollResponse> addEmployee(
            @Valid @RequestBody EmployeePayrollRequest request) {
        return new ResponseEntity<>(service.addEmployee(request), HttpStatus.CREATED);
    }

    // Get employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollResponse> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployee(id));
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeePayrollResponse>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    // Update employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollResponse> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeePayrollRequest request) {
        return ResponseEntity.ok(service.updateEmployee(id, request));
    }

    // Delete employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
