package com.test.parameta.application.dto;

import com.test.parameta.domain.DocumentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class EmployeeDTO {

    private String name;
    private String lastName;
    private DocumentType documentType;
    private String documentNumber;
    private LocalDate birthdate;
    private LocalDate bindingDate;
    private Period bindingTime;
    private Period age;

    private String role;
    double salary;
}
