package com.github.songlebao.payroll.database;

import com.github.songlebao.payroll.model.Employee;
import com.github.songlebao.payroll.model.TimeCard;

import java.util.List;

public interface PayrollDatabase {
    void addTimeCard(int empId, TimeCard timeCard);
    List<Employee> getAllEmployees();
    Employee getEmployee(int empId);
    void addEmployee(int empId, Employee employee);
    void clear();
}
