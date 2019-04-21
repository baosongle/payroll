package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.Employee;
import lombok.Data;

@Data
public abstract class ChangeEmployeeTransaction implements Transacton {
	private PayrollDatabase database = PayrollDatabaseImpl.getDatabase();

	private Integer empId;

	abstract void change(Employee employee);

	@Override
	public void execute() {
		Employee employee = database.getEmployee(empId);
		if (employee != null)
			change(employee);
	}
}
