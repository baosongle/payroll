package com.github.songlebao.payroll.database;

import com.github.songlebao.payroll.model.Employee;

import java.util.List;

public interface PayrollDatabase {
    List<Employee> getAllEmployees();
    Employee getEmployee(int empId);
    void addEmployee(int empId, Employee employee);
    void clear();
}
