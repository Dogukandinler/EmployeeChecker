package com.example.employeechecker.controller;

import com.example.employeechecker.dto.UserDto;
import com.example.employeechecker.service.UserService;
import jakarta.validation.Valid;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserDto> getUsers() {
    return userService.getUsers();
  }


 // @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping
  public UserDto createUser(@Valid @RequestBody UserDto userDto) {
    return userService.createUser(userDto);
  }
}
