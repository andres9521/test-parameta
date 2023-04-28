package com.test.parameta.application.dto;

import com.test.parameta.domain.DocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private DocumentType documentType;

    @NotBlank
    private String documentNumber;

    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "Invalid status date")
    private String birthdate;

    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "Invalid status date")
    private String bindingDate;

    private String bindingTime;

    private String age;

    @NotBlank
    private String role;

    @NotNull
    private double salary;
}
