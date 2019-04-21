package com.github.songlebao.payroll.database;

import com.github.songlebao.payroll.model.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PayrollDatabaseImpl implements PayrollDatabase {
    private Map<Integer, Employee> employees = new ConcurrentHashMap<>();

    private PayrollDatabaseImpl() { }

    @Override
    public List<Employee> getAllEmployees() {
        return new LinkedList<>(employees.values());
    }

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
