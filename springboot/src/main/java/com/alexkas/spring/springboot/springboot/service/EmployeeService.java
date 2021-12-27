package com.alexkas.spring.springboot.springboot.service;


import com.alexkas.spring.springboot.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public int saveEmployee(Employee employee);

    public Employee fiendEmployeeById(int id);

    public int deleteEmployee(int id);

    public int updateEmployee(Employee employee);
}
