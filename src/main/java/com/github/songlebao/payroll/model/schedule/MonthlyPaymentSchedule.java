package com.github.songlebao.payroll.model.schedule;

import java.time.LocalDate;

public class MonthlyPaymentSchedule extends PaymentSchedule {
	@Override
	public boolean isPayDate(LocalDate date) {
        return date.lengthOfMonth() == date.getDayOfMonth();
	}
}
