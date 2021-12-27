package com.alexkas.spring.springboot.springboot.dao;

import com.alexkas.spring.springboot.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * from employee", BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public int saveEmployee(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employee (name, surname, department, salary, job_Title," +
                        " data_Of_Birth) VALUES (?,?,?,?,?,?)",
                new Object[]{employee.getName(), employee.getSurname(), employee.getDepartment(),
                        employee.getSalary(), employee.getJobTitle(), employee.getDataOfBirth()});
    }

    @Override
    public int updateEmployee(Employee employee) {
        return jdbcTemplate.update("UPDATE employee SET name=?, surname=?, department=?, salary=?, job_Title=?," +
                        " data_Of_Birth=?" + "WHERE id=?",
                new Object[]{employee.getName(), employee.getSurname(), employee.getDepartment(), employee.getSalary(),
                        employee.getJobTitle(), employee.getDataOfBirth(), employee.getId()});
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id=?",
                BeanPropertyRowMapper.newInstance(Employee.class), id);
        return employee;
    }

    @Override
    public int deleteEmployee(int id) {
        return jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
    }
}
