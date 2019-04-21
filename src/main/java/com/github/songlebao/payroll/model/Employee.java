package com.github.songlebao.payroll.model;

import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.method.PaymentMethod;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {
    private Integer empId;
    private String name;
    private String address;

    private PaymentClassification paymentClassification;
    private PaymentSchedule paymentSchedule;
    private PaymentMethod paymentMethod;

    public boolean isPayDate(LocalDate date) {
        return paymentSchedule.isPayDate(date);
    }

    public void payDay(Paycheck paycheck) {

    }
}
