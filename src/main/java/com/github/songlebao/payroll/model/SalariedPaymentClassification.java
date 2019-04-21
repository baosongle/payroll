package com.github.songlebao.payroll.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SalariedPaymentClassification extends PaymentClassification {
    private Double salary;

    public SalariedPaymentClassification(Double salary) {
        this.salary = salary;
    }
}
