package com.github.songlebao.payroll.model.classification;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HourlyPaymentClassification extends PaymentClassification {
	private Double hourlyRate;

	public HourlyPaymentClassification(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}
