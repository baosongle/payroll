package com.github.songlebao.payroll.database;

import com.github.songlebao.payroll.model.Employee;
import com.github.songlebao.payroll.model.TimeCard;
import com.github.songlebao.payroll.model.classification.HourlyPaymentClassification;
import com.github.songlebao.payroll.model.classification.PaymentClassification;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PayrollDatabaseImpl implements PayrollDatabase {
    private Map<Integer, Employee> employees = new ConcurrentHashMap<>();

    private PayrollDatabaseImpl() { }

    @Override
    public void addTimeCard(int empId, TimeCard timeCard) {
        Employee employee = getEmployee(empId);
        PaymentClassification classification = employee.getPaymentClassification();
        if (classification instanceof HourlyPaymentClassification) {
            ((HourlyPaymentClassification) classification).getTimeCards().add(timeCard);
        }
    }

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
