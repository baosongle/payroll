package com.github.songlebao.payroll.model;

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
