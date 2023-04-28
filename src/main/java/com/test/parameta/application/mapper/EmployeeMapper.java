package com.test.parameta.application.mapper;

import com.test.parameta.application.dto.EmployeeDTO;
import com.test.parameta.domain.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeDTO employeeDTO){
        Employee e = new Employee();
        e.setName(employeeDTO.getName());
        e.setLastName(employeeDTO.getLastName());
        e.setDocumentType(employeeDTO.getDocumentType());
        e.setDocumentNumber(employeeDTO.getDocumentNumber());
        e.setBirthdate(LocalDate.parse(employeeDTO.getBirthdate()));
        e.setBindingDate(LocalDate.parse(employeeDTO.getBindingDate()));
        e.setRole(employeeDTO.getRole());
        e.setSalary(employeeDTO.getSalary());
        return e;
    }

    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(employee.getName());
        dto.setLastName(employee.getLastName());
        dto.setDocumentType(employee.getDocumentType());
        dto.setDocumentNumber(employee.getDocumentNumber());
        dto.setBirthdate(employee.getBirthdate().toString());
        dto.setBindingDate(employee.getBindingDate().toString());
        Period age = employee.getAge();
        dto.setAge(String.format("%d years %d months %d days", age.getYears(), age.getMonths(), age.getDays()));
        Period bindingTime = employee.getBindingTime();
        dto.setBindingTime(String.format("%d years %d months %d days", bindingTime.getYears(), bindingTime.getMonths(), bindingTime.getDays()));
        dto.setRole(employee.getRole());
        dto.setSalary(employee.getSalary());
        return dto;
    }
}
