package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.Employee;
import com.github.songlebao.payroll.model.TimeCard;
import com.github.songlebao.payroll.model.classification.HourlyPaymentClassification;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class TimeCardTransactionTest {
	private PayrollDatabase database = PayrollDatabaseImpl.getDatabase();

	@Test
	public void testAddTimeCardTransaction() {
		int empId = 2;
		String name = "bao";
		String address = "beijing";
		double hourlyRate = 20;
		AddEmployeeTransaction addTransaction = new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate);
		addTransaction.execute();

		LocalDate date = LocalDate.of(2001, 10, 31);
		double hour = 8D;
		TimeCardTransaction timeCardTransaction = new TimeCardTransaction(date, hour, empId);
		timeCardTransaction.execute();

		Employee employee = database.getEmployee(empId);
		assertNotNull(employee);

		HourlyPaymentClassification classification = (HourlyPaymentClassification) employee.getPaymentClassification();
		assertNotNull(classification);

		TimeCard timeCard = classification.getTimeCard(date);
        assertNotNull(timeCard);
        assertEquals(8D, timeCard.getHours(), 0.01);
	}
}
