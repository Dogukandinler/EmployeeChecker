package com.example.employeechecker.Service;


import com.example.employeechecker.Dto.EmployeeDto;
import com.example.employeechecker.Model.Employee;
import com.example.employeechecker.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.employeechecker.Mapper.EmployeeMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public List<EmployeeDto> getAllEmployee(){

        return employeeRepository.findAll()
                .stream().map(EmployeeMapper.INSTANCE::toDto).toList();
    }

    public Employee createEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public Employee getOneEmployeeByName(String name) {
        return employeeRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public Employee getOneEmployee(Long EmployeeId) {
        return employeeRepository.findById(EmployeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public  void deleteOneEmployee(Long EmployeeId) {
        employeeRepository.deleteById(EmployeeId);
    }
}
