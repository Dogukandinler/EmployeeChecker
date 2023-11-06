package com.example.employeechecker.Controller;

import com.example.employeechecker.Dto.EmployeeDto;
import com.example.employeechecker.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor

public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDto> getAllEmployee(){
        return  employeeService.getAllEmployee();
    }
}
