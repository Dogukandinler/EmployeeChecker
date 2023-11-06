package com.example.employeechecker.Service;


import com.example.employeechecker.Dto.EmployeeDto;
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
}
