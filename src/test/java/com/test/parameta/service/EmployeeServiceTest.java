package com.test.parameta.service;

import com.test.parameta.domain.DocumentType;
import com.test.parameta.domain.Employee;
import com.test.parameta.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void testCreateEmployee() {
        // given
        Employee employee = new Employee();
        employee.setName("andres");
        employee.setLastName("robledo");
        employee.setDocumentType(DocumentType.valueOf("CEDULA"));
        employee.setDocumentNumber("1234556");
        employee.setBirthdate(LocalDate.of(1995, 4, 21));
        employee.setBindingDate(LocalDate.of(2020, 4, 21));
        employee.setRole("developer");
        employee.setSalary(50000.0);

        when(employeeRepository.save(employee)).thenReturn(employee);

        // when
        Employee createdEmployee = employeeService.create(employee);

        // then
        verify(employeeRepository).save(employee);
        assertEquals(employee.getName(), createdEmployee.getName());
        assertEquals(employee.getLastName(), createdEmployee.getLastName());
        assertEquals(employee.getDocumentType(), createdEmployee.getDocumentType());
        assertEquals(employee.getDocumentNumber(), createdEmployee.getDocumentNumber());
        assertEquals(employee.getBirthdate(), createdEmployee.getBirthdate());
        assertEquals(employee.getBindingDate(), createdEmployee.getBindingDate());
        assertEquals(employee.getRole(), createdEmployee.getRole());
        assertEquals(employee.getSalary(), createdEmployee.getSalary());
    }
}

