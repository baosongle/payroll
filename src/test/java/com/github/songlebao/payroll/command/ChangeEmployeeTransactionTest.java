package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.Employee;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeEmployeeTransactionTest {
	private PayrollDatabase database = PayrollDatabaseImpl.getDatabase();

	@Test
	public void testChangeNameTransaction() {
		int empId = 1;
		String name = "baosongle";
		String address = "haidian";
		double hourlyRate = 40;

		AddEmployeeTransaction addTransaction = new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate);
		addTransaction.execute();

		String newName = "happy";
		ChangeEmployeeTransaction changeTransaction = new ChangeNameTransaction(empId, newName);
		changeTransaction.execute();

		Employee employee = database.getEmployee(empId);
		assertNotNull(employee);
		assertEquals(newName, employee.getName());
	}
}
