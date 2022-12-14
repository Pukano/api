package com.ocr.controller;

import com.ocr.model.Employee;
import com.ocr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // bean... insert the method return in JSON format in the body of the HTTP response
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isPresent()){
            return employee.get();
        } else {
            return null;
        }
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> emp = employeeService.getEmployee(id);
        if (emp.isPresent()){
            Employee currentEmployee = emp.get();

            String firstName = employee.getFirstName();
            if (firstName != null) {
                currentEmployee.setFirstName(firstName);
            }

            String lastName = employee.getLastName();
            if (lastName != null) {
                currentEmployee.setLastName(lastName);
            }

            String email = employee.getEmail();
            if (email != null) {
                currentEmployee.setEmail(email);
            }

            String password = employee.getPassword();
            if (password != null) {
                currentEmployee.setPassword(password);
            }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;

        } else {
            return null;
        }
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);}

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id){
        employeeService.deleteEmployee(id);
    }
}
