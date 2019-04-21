package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.Employee;
import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
	abstract PaymentClassification getClassification();
	abstract PaymentSchedule getSchedule();

	@Override
	void change(Employee employee) {
		if (employee != null) {
			employee.setPaymentClassification(getClassification());
			employee.setPaymentSchedule(getSchedule());
		}
	}
}
