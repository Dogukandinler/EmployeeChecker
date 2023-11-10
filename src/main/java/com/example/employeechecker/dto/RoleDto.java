package com.example.employeechecker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto extends BaseDto {

  private Long id;

  private String authority;
}
