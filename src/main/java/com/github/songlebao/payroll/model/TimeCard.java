package com.github.songlebao.payroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeCard {
	private Integer empId;
	private LocalDate date;
	private Double hours;
}
