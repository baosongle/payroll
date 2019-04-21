package com.github.songlebao.payroll.command;

import com.github.songlebao.payroll.database.PayrollDatabase;
import com.github.songlebao.payroll.database.PayrollDatabaseImpl;
import com.github.songlebao.payroll.model.*;
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

        PaymentSchedule paymentSchedule = employee.getPaymentSchedule();
        assertNotNull(paymentSchedule);
    }
}
