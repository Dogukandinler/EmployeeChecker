package com.example.employeechecker.Dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter

public class EmployeeDto {
    private Long Id;
    private String name;
    private String surname;
    private LocalDateTime createdDate;
    private Date updateDate;
    private String pcIdentifier;


}
