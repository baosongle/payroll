package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.model.classification.HourlyPaymentClassification;
import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import com.github.songlebao.payroll.model.schedule.WeeklyPaymentSchedule;
import lombok.Data;
import lombok.EqualsAndHashCode;

// 有些雇员是钟点工，按照他们雇员记录中的每小时报酬字段对他们支付，每天提交工作时间卡，记录了日期和工作时长，如果每天工作超过 8 个小时，
// 超过的部分按照 1.5 倍支付，每周五对他们支付
@Data
@EqualsAndHashCode(callSuper = true)
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {
	private Double hourlyRate;

	public AddHourlyEmployeeTransaction(Integer empId, String name, String address, Double hourlyRate) {
		setEmpId(empId);
		setName(name);
		setAddress(address);
		this.hourlyRate = hourlyRate;
	}

	@Override
	PaymentClassification getClassification() {
		return new HourlyPaymentClassification(hourlyRate);
	}

	@Override
	PaymentSchedule getSchedule() {
		return new WeeklyPaymentSchedule();
	}
}
