package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.*;
import lombok.Data;

@Data
public abstract class AddEmployeeTransaction implements Transacton {
    private PayrollDatabase database = PayrollDatabaseImpl.getDatabase();

    abstract PaymentClassification getClassification();
    abstract PaymentSchedule getSchedule();

    private Integer empId;
    private String name;
    private String address;

    @Override
    public void execute() {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setName(name);
        employee.setAddress(address);
        employee.setPaymentClassification(getClassification());
        employee.setPaymentSchedule(getSchedule());
        employee.setPaymentMethod(new HoldPaymentMethod());

        database.addEmployee(empId, employee);
    }
}
