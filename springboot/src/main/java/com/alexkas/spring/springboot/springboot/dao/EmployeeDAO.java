package com.alexkas.spring.springboot.springboot.dao;


import com.alexkas.spring.springboot.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public int saveEmployee(Employee employee);

    public Employee findEmployeeById(int id);

    public int deleteEmployee(int id);

    public int updateEmployee(Employee employee);
}
