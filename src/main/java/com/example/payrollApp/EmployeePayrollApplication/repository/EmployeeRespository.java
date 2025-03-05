package com.example.payrollApp.EmployeePayrollApplication.repository;

import com.example.payrollApp.EmployeePayrollApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee,Long> {

}
