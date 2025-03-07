package com.example.payrollApp.EmployeePayrollApplication.controller;

import com.example.payrollApp.EmployeePayrollApplication.dto.EmployeeDto;
import com.example.payrollApp.EmployeePayrollApplication.dto.ResponseDto;
import com.example.payrollApp.EmployeePayrollApplication.model.Employee;
import com.example.payrollApp.EmployeePayrollApplication.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<ResponseDto> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ResponseDto response = new ResponseDto("All employees retrieved successfully", employees);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            ResponseDto response = new ResponseDto("Employee retrieved successfully", employee.get());
            return ResponseEntity.ok(response);
        } else {
            ResponseDto response = new ResponseDto("Employee not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ResponseDto response = new ResponseDto("Invalid input data", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(response);
        }
        Employee createdEmployee = employeeService.createEmployee(employeeDTO);
        ResponseDto response = new ResponseDto("Employee created successfully", createdEmployee);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ResponseDto response = new ResponseDto("Invalid input data", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(response);
        }
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        ResponseDto response = new ResponseDto("Employee updated successfully", updatedEmployee);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        ResponseDto response = new ResponseDto("Employee deleted successfully", null);
        return ResponseEntity.noContent().build();
    }
}
