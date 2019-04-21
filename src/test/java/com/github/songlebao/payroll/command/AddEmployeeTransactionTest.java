package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.*;
import com.github.songlebao.payroll.model.classification.CommissionedPaymentClassification;
import com.github.songlebao.payroll.model.classification.HourlyPaymentClassification;
import com.github.songlebao.payroll.model.classification.PaymentClassification;
import com.github.songlebao.payroll.model.classification.SalariedPaymentClassification;
import com.github.songlebao.payroll.model.method.HoldPaymentMethod;
import com.github.songlebao.payroll.model.method.PaymentMethod;
import com.github.songlebao.payroll.model.schedule.BiWeeklyPaymentSchedule;
import com.github.songlebao.payroll.model.schedule.MonthlyPaymentSchedule;
import com.github.songlebao.payroll.model.schedule.PaymentSchedule;
import com.github.songlebao.payroll.model.schedule.WeeklyPaymentSchedule;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddEmployeeTransactionTest {
    private PayrollDatabase database = PayrollDatabaseImpl.getDatabase();

    @Test
    public void testAddSalariedEmployeeTransaction() {
        int empId = 1;
        String name = "baosongle";
        String address = "haidian";
        Double salary = 100.0D;
        AddEmployeeTransaction transaction = new AddSalariedEmployeeTransaction(empId, name, address, salary);
        transaction.execute();

        Employee employee = database.getEmployee(empId);
        assertNotNull(employee);
        assertEquals((Integer) empId, employee.getEmpId());
        assertEquals(name, employee.getName());
        assertEquals(address, employee.getAddress());

        PaymentClassification classification = employee.getPaymentClassification();
        assertNotNull(classification);
        assertEquals(salary, ((SalariedPaymentClassification) classification).getSalary());

        PaymentMethod paymentMethod = employee.getPaymentMethod();
        assertNotNull(paymentMethod);
        assertTrue(paymentMethod instanceof HoldPaymentMethod);

        PaymentSchedule paymentSchedule = employee.getPaymentSchedule();
        assertNotNull(paymentSchedule);
        assertTrue(paymentSchedule instanceof MonthlyPaymentSchedule);
    }

    @Test
    public void testAddCommissionedEmployeeTransaction() {
        int empId = 2;
        String name = "baosongle";
        String address = "fangshan";
        Double salary = 200D;
        Double commissionedRate = 0.1D;
        AddEmployeeTransaction transaction = new AddCommissionedEmployeeTransaction(empId, name, address, salary, commissionedRate);
        transaction.execute();

        Employee employee = database.getEmployee(empId);
        assertNotNull(employee);
        assertEquals((Integer) empId, employee.getEmpId());
        assertEquals(name, employee.getName());
        assertEquals(address, employee.getAddress());

        PaymentClassification classification = employee.getPaymentClassification();
        assertNotNull(classification);
        assertEquals(salary, ((CommissionedPaymentClassification) employee.getPaymentClassification()).getSalary());
        assertEquals(commissionedRate, ((CommissionedPaymentClassification) employee.getPaymentClassification()).getCommissionedRate());

        PaymentMethod paymentMethod = employee.getPaymentMethod();
        assertNotNull(paymentMethod);
        assertTrue(paymentMethod instanceof HoldPaymentMethod);

        PaymentSchedule paymentSchedule = employee.getPaymentSchedule();
        assertNotNull(paymentSchedule);
        assertTrue(paymentSchedule instanceof BiWeeklyPaymentSchedule);
    }

    @Test
    public void testAddHourlyEmployeeTransactionTest() {
        int empId = 3;
        String name = "baosongle";
        String address = "chaoyang";
        Double hourlyRate = 20D;
        AddEmployeeTransaction transaction = new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate);
        transaction.execute();

        Employee employee = database.getEmployee(empId);
        assertNotNull(employee);
        assertEquals((Integer) empId, employee.getEmpId());
        assertEquals(name, employee.getName());
        assertEquals(address, employee.getAddress());

        PaymentClassification classification = employee.getPaymentClassification();
        assertNotNull(classification);
        assertEquals(hourlyRate, ((HourlyPaymentClassification) employee.getPaymentClassification()).getHourlyRate());

        PaymentMethod paymentMethod = employee.getPaymentMethod();
        assertNotNull(paymentMethod);
        assertTrue(paymentMethod instanceof HoldPaymentMethod);

        PaymentSchedule paymentSchedule = employee.getPaymentSchedule();
        assertNotNull(paymentSchedule);
        assertTrue(paymentSchedule instanceof WeeklyPaymentSchedule);
    }
}
