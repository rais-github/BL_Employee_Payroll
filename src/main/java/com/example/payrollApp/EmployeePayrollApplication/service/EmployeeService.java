package com.example.payrollApp.EmployeePayrollApplication.service;



import com.example.payrollApp.EmployeePayrollApplication.dto.EmployeeDto;
import com.example.payrollApp.EmployeePayrollApplication.model.Employee;
import com.example.payrollApp.EmployeePayrollApplication.repository.EmployeeRespository;
import com.example.payrollApp.EmployeePayrollApplication.service.Interface.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRespository employeeRespository;

    public EmployeeService(EmployeeRespository employeeRespository){
        this.employeeRespository=employeeRespository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRespository.findAll();
    }
    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRespository.findById(id);
    }
    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getAddress() == null || employeeDto.getAddress().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty!");
        }

        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setRole(employeeDto.getRole());
        employee.setSalary(employeeDto.getSalary());
        employee.setDateOfJoining(employeeDto.getDateOfJoining());
        employee.setLeaveBalance(employeeDto.getLeaveBalance());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setAddress(employeeDto.getAddress());

        return employeeRespository.save(employee);
    }
    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRespository.findById(id).orElseThrow();
        employee.setName(employeeDetails.getName());
        employee.setRole(employeeDetails.getRole());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDateOfJoining(employeeDetails.getDateOfJoining());
        employee.setLeaveBalance(employeeDetails.getLeaveBalance());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        employee.setAddress(employeeDetails.getAddress());
        return employeeRespository.save(employee);
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeRespository.deleteById(id);
    }
}

