package com.github.songlebao.payroll.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
public class Paycheck {
	private LocalDate payDate;
	private Double grossPay;
	private Double deductions;
	private Double netPay;

	private Map<String, String> fields = new HashMap<>();

	public Paycheck(LocalDate payDate) {
		this.payDate = payDate;
	}

	public String getField(String name) {
		return fields.get(name);
	}
}
