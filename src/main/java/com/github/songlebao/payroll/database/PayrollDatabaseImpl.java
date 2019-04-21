package com.github.songlebao.payroll.database;

import com.github.songlebao.payroll.model.Employee;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PayrollDatabaseImpl implements PayrollDatabase {
    private Map<Integer, Employee> employees = new ConcurrentHashMap<>();

    @Override
    public Employee getEmployee(int empId) {
        return employees.get(empId);
    }

    @Override
    public void addEmployee(int empId, Employee employee) {
        employees.put(empId, employee);
    }

    @Override
    public void clear() {
        employees.clear();
    }

    public static PayrollDatabase getDatabase() {
        return PayrollDatabaseHolder.database;
    }

    private static class PayrollDatabaseHolder {
        private static PayrollDatabase database = new PayrollDatabaseImpl();
    }
}