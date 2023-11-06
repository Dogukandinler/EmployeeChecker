package com.example.employeechecker.Mapper;

import com.example.employeechecker.Dto.EmployeeDto;
import com.example.employeechecker.Model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toDto(Employee employee);
}