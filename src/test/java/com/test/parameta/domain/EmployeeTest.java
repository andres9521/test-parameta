package com.test.parameta.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

    @Test
    public void testSetBirthdateWithUnderageEmployee() {
        Employee employee = new Employee();
        LocalDate underageBirthdate = LocalDate.now().minusYears(17);
        try {
            employee.setBirthdate(underageBirthdate);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Trabajador menor de edad", e.getMessage());
        }
    }

    @Test
    public void testSetBirthdateWithLegalAgeEmployee() {
        Employee employee = new Employee();
        LocalDate legalAgeBirthdate = LocalDate.now().minusYears(18);
        employee.setBirthdate(legalAgeBirthdate);
        assertEquals(Period.between(legalAgeBirthdate, LocalDate.now()), employee.getAge());
    }

    @Test
    public void testSetBindingDate() {
        Employee employee = new Employee();
        LocalDate bindingDate = LocalDate.now().minusMonths(6);
        employee.setBindingDate(bindingDate);
        assertEquals(Period.between(bindingDate, LocalDate.now()), employee.getBindingTime());
    }
}