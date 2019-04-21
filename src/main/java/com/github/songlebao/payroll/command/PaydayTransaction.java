package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.Employee;
import com.github.songlebao.payroll.model.Paycheck;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaydayTransaction implements Transacton {
	private PayrollDatabase database = PayrollDatabaseImpl.getDatabase();

	@Getter
	@Setter
	private LocalDate date;

	private Map<Integer, Paycheck> paycheckMap = new HashMap<>();

	public PaydayTransaction(LocalDate date) {
		this.date = date;
	}

	@Override
	public void execute() {
		List<Employee> employees = database.getAllEmployees();

		for (Employee employee : employees) {
			if (employee.isPayDate(date)) {
				Paycheck paycheck = new Paycheck(date);
				putPaycheck(employee.getEmpId(), paycheck);
				employee.payDay(paycheck);
			}
		}
	}

	public Paycheck getPaycheck(Integer empId) {
		return paycheckMap.get(empId);
	}

	private void putPaycheck(Integer empId, Paycheck paycheck) {
		paycheckMap.put(empId, paycheck);
	}
}
