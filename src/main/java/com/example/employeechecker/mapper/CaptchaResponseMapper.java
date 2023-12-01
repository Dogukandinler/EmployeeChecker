package com.example.employeechecker.mapper;


import com.example.employeechecker.dto.CaptchaResponseDto;
import com.example.employeechecker.dto.RoleDto;
import com.example.employeechecker.model.CaptchaResponse;
import com.example.employeechecker.model.Role;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CaptchaResponseMapper {

    CaptchaResponseDto toDto(CaptchaResponse captchaResponse);

    CaptchaResponse toEntity(CaptchaResponse captchaResponse);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePartial(@MappingTarget CaptchaResponse entity, CaptchaResponseDto dto);
}
