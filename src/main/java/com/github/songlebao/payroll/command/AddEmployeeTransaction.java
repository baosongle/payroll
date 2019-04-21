package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.*;
import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.method.HoldPaymentMethod;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import lombok.Getter;
import lombok.Setter;

public abstract class AddEmployeeTransaction implements Transacton {
    private PayrollDatabase database = PayrollDatabaseImpl.getDatabase();

    abstract PaymentClassification getClassification();
    abstract PaymentSchedule getSchedule();

    @Setter
    @Getter
    private Integer empId;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
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
