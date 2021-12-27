package com.alexkas.spring.springboot.springboot.service;

import com.alexkas.spring.springboot.springboot.dao.EmployeeDAO;
import com.alexkas.spring.springboot.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public int saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    public Employee fiendEmployeeById(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
}
