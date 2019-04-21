package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.classification.SalariedPaymentClassification;
import com.github.songlebao.payroll.model.schedule.MonthlyPaymentSchedule;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
// 有些雇员完全以月薪支付，每月的最后一个工作日对他们进行支付，他们的雇员记录中有一个月薪字段
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
