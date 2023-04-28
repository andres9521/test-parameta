package com.test.parameta.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    private String documentNumber;

    private LocalDate birthdate;

    private LocalDate bindingDate;

    @Transient
    private Period bindingTime;
    @Transient
    private Period age;
    private String role;
    double salary;

    public void setBirthdate(LocalDate birthdate) {
        int years = Period.between(birthdate, LocalDate.now()).getYears();
        if(years<18){
            throw new IllegalArgumentException("Trabajador menor de edad");
        }
        this.birthdate = birthdate;
        this.age = Period.between(birthdate, LocalDate.now());
    }

    public void setBindingDate(LocalDate bindingDate) {
        this.bindingDate = bindingDate;
        this.bindingTime = Period.between(bindingDate, LocalDate.now());
    }
}
