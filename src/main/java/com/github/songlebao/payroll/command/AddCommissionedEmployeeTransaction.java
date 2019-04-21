package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.schedule.BiWeeklyPaymentSchedule;
import com.github.songlebao.payroll.model.classification.CommissionedPaymentClassification;
import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
// 有些雇员是带薪雇员（salary），每隔一周的周五（biweekly），按照他们的销售凭条，支付给他们酬金（commission）
public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction {
    private Double salary;
    private Double commissionedRate;

    public AddCommissionedEmployeeTransaction(Integer empId, String name, String address, Double salary, Double commissionedRate) {
        setEmpId(empId);
        setName(name);
        setAddress(address);
        this.salary = salary;
        this.commissionedRate = commissionedRate;
    }

    @Override
    PaymentClassification getClassification() {
        return new CommissionedPaymentClassification(salary, commissionedRate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new BiWeeklyPaymentSchedule();
    }
}
