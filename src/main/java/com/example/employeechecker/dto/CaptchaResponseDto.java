package com.example.employeechecker.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CaptchaResponseDto extends BaseDto {
    private String macAddress;
    private int responseTimeSeconds;

    // Getters and setters
}