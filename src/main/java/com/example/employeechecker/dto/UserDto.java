package com.example.employeechecker.dto;

import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseDto {

    private Long id;

    private String name;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    private String macAddress;

    private Set<CaptchaResponseDto> captchaResponse;


    private Set<RoleDto> authorities;
}
