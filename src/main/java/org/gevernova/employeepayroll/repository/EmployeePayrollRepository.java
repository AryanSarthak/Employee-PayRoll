package org.gevernova.employeepayroll.repository;

import org.gevernova.employeepayroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates this interface is a Spring Data repository
public interface EmployeePayrollRepository extends JpaRepository<Employee, Long> {
    // Inherits CRUD methods
}

