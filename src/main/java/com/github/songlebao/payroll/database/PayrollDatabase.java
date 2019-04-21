package com.github.songlebao.payroll.database;

import com.github.songlebao.payroll.model.Employee;

public interface PayrollDatabase {
    Employee getEmployee(int empId);
    void addEmployee(int empId, Employee employee);
    void clear();
}
