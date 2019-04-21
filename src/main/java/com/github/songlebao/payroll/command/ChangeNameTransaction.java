package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
	private String newName;

	public ChangeNameTransaction(Integer empId, String newName) {
		setEmpId(empId);
		this.newName = newName;
	}

	@Override
	void change(Employee employee) {
		employee.setName(newName);
	}
}
