package com.alexkas.spring.springboot.springboot.Controller;

import com.alexkas.spring.springboot.springboot.entity.Employee;
import com.alexkas.spring.springboot.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http//localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.fiendEmployeeById(id);

        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        try {
            employeeService.saveEmployee(new Employee(employee.getName(), employee.getSurname(), employee.getDepartment(),
                    employee.getSalary(), employee.getJobTitle(), employee.getDataOfBirth()));
            return new ResponseEntity<>("Employee was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        Employee emp = employeeService.fiendEmployeeById(id);

        if (emp != null) {
            emp.setId(id);
            emp.setName(employee.getName());
            emp.setSurname(employee.getSurname());
            emp.setDepartment(employee.getDepartment());
            emp.setSalary(employee.getSalary());
            emp.setJobTitle(employee.getJobTitle());
            emp.setDataOfBirth(employee.getDataOfBirth());
            employeeService.updateEmployee(emp);

            return new ResponseEntity<>("Employee was update successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Employee with id= " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") int id) {
        try {
            int idForDelete = employeeService.deleteEmployee(id);
            if (idForDelete == 0) {
                return new ResponseEntity<>("Cannot find Employee with id= " + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Employee was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete Employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
