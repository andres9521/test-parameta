package com.test.parameta.application.mapper;

import com.test.parameta.application.dto.EmployeeDTO;
import com.test.parameta.domain.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeDTO employeeDTO){
        Employee e = new Employee();
        e.setName(employeeDTO.getName());
        e.setLastName(employeeDTO.getLastName());
        e.setDocumentType(employeeDTO.getDocumentType());
        e.setDocumentNumber(employeeDTO.getDocumentNumber());
        e.setBirthdate(employeeDTO.getBirthdate());
        e.setBindingDate(employeeDTO.getBindingDate());
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
        dto.setBirthdate(employee.getBirthdate());
        dto.setBindingDate(employee.getBindingDate());
        dto.setAge(employee.getAge());
        dto.setBindingTime(employee.getBindingTime());
        dto.setRole(employee.getRole());
        dto.setSalary(employee.getSalary());
        return dto;
    }
}
