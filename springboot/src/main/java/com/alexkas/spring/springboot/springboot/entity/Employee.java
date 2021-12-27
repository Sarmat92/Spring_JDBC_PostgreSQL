package com.alexkas.spring.springboot.springboot.entity;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String department;
    private int salary;
    private String jobTitle;
    private String dataOfBirth;

//    @Column(name = "gender")
//    @Enumerated(EnumType.STRING)
//    private Gender gender;

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary, String jobTitle, String dataOfBirth) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.dataOfBirth = dataOfBirth;
    }

    public Employee(int id, String name, String surname, String department, int salary, String jobTitle, String dataOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.dataOfBirth = dataOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                ", dataOfBirth='" + dataOfBirth + '\'' +
                '}';
    }
}
