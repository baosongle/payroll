package com.github.songlebao.payroll.model.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyPaymentSchedule extends PaymentSchedule {
	@Override
	public boolean isPayDate(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
	}
}
