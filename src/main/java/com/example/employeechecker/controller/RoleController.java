package com.example.employeechecker.controller;

import com.example.employeechecker.dto.RoleDto;
import com.example.employeechecker.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping
  public List<RoleDto> getRoles() {
    return roleService.getRoles();
  }

  @PostMapping
  public RoleDto createRole(@RequestBody RoleDto userDto) {
    return roleService.createRole(userDto);
  }
}
