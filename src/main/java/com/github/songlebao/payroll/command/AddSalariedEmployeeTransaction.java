package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction {
    private Double salary;

    public AddSalariedEmployeeTransaction(Integer empId, String name, String address, Double salary) {
        setEmpId(empId);
        setName(name);
        setAddress(address);
        setSalary(salary);
    }

    @Override
    PaymentClassification getClassification() {
        return new SalariedPaymentClassification(salary);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new MonthlyPaymentSchedule();
    }
}
