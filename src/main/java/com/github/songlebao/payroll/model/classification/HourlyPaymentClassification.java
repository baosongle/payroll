package com.github.songlebao.payroll.model.classification;

import com.github.songlebao.payroll.model.TimeCard;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class HourlyPaymentClassification extends PaymentClassification {
	private Double hourlyRate;
	private List<TimeCard> timeCards = new LinkedList<>();

	public HourlyPaymentClassification(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public TimeCard getTimeCard(LocalDate date) {
		return timeCards.stream()
				.filter(timeCard -> timeCard.getDate().equals(date))
				.findFirst()
				.orElse(null);
	}
}
