package com.example.payrollApp.EmployeePayrollApplication.service.Interface;

import com.example.payrollApp.EmployeePayrollApplication.dto.EmployeeDto;
import com.example.payrollApp.EmployeePayrollApplication.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee createEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);
}
