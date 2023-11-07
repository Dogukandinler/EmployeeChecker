package com.example.employeechecker.Controller;

import com.example.employeechecker.Dto.EmployeeDto;
import com.example.employeechecker.Model.Employee;
import com.example.employeechecker.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
    public Employee createEmployee(@RequestBody Employee newEmployee) {
        return  employeeService.createEmployee(newEmployee);
    }

    @GetMapping("/{employeeId}")
    public Employee getOneEmployee(@PathVariable Long employeeId){
        return employeeService.getOneEmployee(employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteOneEmployee(@PathVariable Long employeeId){
        employeeService.deleteOneEmployee(employeeId);


    }
}
