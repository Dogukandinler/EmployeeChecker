package com.example.employeechecker.dto;

import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDto {

  // these are must be null in requests and set in backend
  @Null private LocalDateTime createdDateTime;

  @Null private LocalDateTime updatedDateTime;

  @Null private String createdBy;

  @Null private String updatedBy;
}
