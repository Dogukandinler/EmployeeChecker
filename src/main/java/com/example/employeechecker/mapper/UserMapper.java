package com.example.employeechecker.mapper;

import com.example.employeechecker.dto.UserDto;
import com.example.employeechecker.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "password", ignore = true)
  UserDto toDto(User entity);

  User toEntity(UserDto entity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updatePartial(@MappingTarget User entity, UserDto dto);
}
