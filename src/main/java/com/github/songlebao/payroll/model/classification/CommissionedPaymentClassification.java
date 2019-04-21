package com.github.songlebao.payroll.model.classification;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommissionedPaymentClassification extends PaymentClassification {
    private Double salary;
    private Double commissionedRate;

    public CommissionedPaymentClassification(Double salary, Double commissionedRate) {
        this.salary = salary;
        this.commissionedRate = commissionedRate;
    }
}
