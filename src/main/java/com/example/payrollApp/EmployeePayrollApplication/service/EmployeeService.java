package com.example.payrollApp.EmployeePayrollApplication.service;

import com.example.payrollApp.EmployeePayrollApplication.dto.EmployeeDto;
import com.example.payrollApp.EmployeePayrollApplication.model.Employee;
import com.example.payrollApp.EmployeePayrollApplication.repository.EmployeeRespository;
import com.example.payrollApp.EmployeePayrollApplication.service.Interface.IEmployeeService;
import org.springframework.stereotype.Service;
import com.example.payrollApp.EmployeePayrollApplication.exceptions.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRespository employeeRespository;

    public EmployeeService(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRespository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRespository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        return employee;
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getAddress() == null || employeeDto.getAddress().isEmpty()) {
            throw new InvalidEmployeeDataException("Address cannot be null or empty!");
        }

        Employee employee = mapToEmployee(employeeDto);
        return employeeRespository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        // Update fields with new values from DTO
        employee.setName(employeeDto.getName());
        employee.setRole(employeeDto.getRole());
        employee.setSalary(employeeDto.getSalary());
        employee.setDateOfJoining(employeeDto.getDateOfJoining());
        employee.setLeaveBalance(employeeDto.getLeaveBalance());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setAddress(employeeDto.getAddress());
        employee.setGender(employeeDto.getGender());
        employee.setNote(employeeDto.getNote());
        employee.setProfilePic(employeeDto.getProfilePic());

        return employeeRespository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRespository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRespository.deleteById(id);
    }

    // Helper method to convert DTO to Entity
    private Employee mapToEmployee(EmployeeDto employeeDto) {
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
        employee.setGender(employeeDto.getGender());
        employee.setNote(employeeDto.getNote());
        employee.setProfilePic(employeeDto.getProfilePic());
        return employee;
    }
}
