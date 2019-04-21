package com.github.songlebao.payroll.model;

import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.method.PaymentMethod;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import lombok.Data;

@Data
public class Employee {
    private Integer empId;
    private String name;
    private String address;

    private PaymentClassification paymentClassification;
    private PaymentSchedule paymentSchedule;
    private PaymentMethod paymentMethod;
}
