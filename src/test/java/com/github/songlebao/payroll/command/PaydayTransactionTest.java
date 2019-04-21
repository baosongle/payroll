package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.Paycheck;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class PaydayTransactionTest {
	@Test
	public void paySingleSalariedEmployeeTest() {
		int empId = 1;
		String name = "baosongle";
		String address = "fangshan";
		double salary = 100;
		AddEmployeeTransaction addTransaction = new AddSalariedEmployeeTransaction(empId, name, address, salary);
		addTransaction.execute();

		LocalDate date = LocalDate.of(2019, 4, 30);
		PaydayTransaction paydayTransaction = new PaydayTransaction(date);
		paydayTransaction.execute();

		Paycheck paycheck = paydayTransaction.getPaycheck(empId);
		assertNotNull(paycheck);
		assertEquals(paycheck.getPayDate(), date);
		assertEquals(salary, paycheck.getGrossPay(), 0.001);
		assertEquals("Hold", paycheck.getField("Disposition"));
		assertEquals(0, paycheck.getDeductions(), 0.001);
		assertEquals(salary, paycheck.getNetPay(), 0.001);
	}

	@Test
	public void paySingleSalariedEmployeeOnWrongDateTest(){

	}
}
