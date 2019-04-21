package com.github.songlebao.payroll.model.schedule;

import java.time.LocalDate;

public abstract class PaymentSchedule {
	public abstract boolean isPayDate(LocalDate date);
}
