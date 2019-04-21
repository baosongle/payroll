package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.classification.HourlyPaymentClassification;
import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import com.github.songlebao.payroll.model.schedule.WeeklyPaymentSchedule;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
	private Double hourlyRate;

	public ChangeHourlyTransaction(Integer empId, Double hourlyRate) {
		setEmpId(empId);
		this.hourlyRate = hourlyRate;
	}

	@Override
	PaymentClassification getClassification() {
		return new HourlyPaymentClassification(hourlyRate);
	}

	@Override
	PaymentSchedule getSchedule() {
		return new WeeklyPaymentSchedule();
	}
}
