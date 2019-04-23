package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.TimeCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeCardTransaction implements Transacton {
	private LocalDate date;
	private Double hour;
	private Integer empId;

	@Override
	public void execute() {
		TimeCard timeCard = new TimeCard(empId, date, hour);
		PayrollDatabase database = PayrollDatabaseImpl.getDatabase();
		database.addTimeCard(empId, timeCard);
	}
}
