package com.example.employeechecker.Dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class EmployeeDto {
    private Long Id;
    private String name;
    private String surname;
    private String pcIdentifier;


}
