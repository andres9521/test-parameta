package com.test.parameta.application.controller;

import com.test.parameta.application.dto.EmployeeDTO;
import com.test.parameta.application.mapper.EmployeeMapper;
import com.test.parameta.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeMapper mapper;
    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(mapper.toDTO(service.create(mapper.toEntity(employeeDTO))));
    }
}
