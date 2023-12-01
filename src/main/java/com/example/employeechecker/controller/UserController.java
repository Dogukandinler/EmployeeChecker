package com.example.employeechecker.controller;

import com.example.employeechecker.dto.UserDto;
import com.example.employeechecker.model.User;
import com.example.employeechecker.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{username}")
    public User  getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);}


    // @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @DeleteMapping("/{username}")
    public void deleteOneEmployee(@PathVariable Long username) {
        userService.deleteOneUser(username);
    }

    @PutMapping("/update/{Id}")
    public UserDto updateUser(@PathVariable long Id, @RequestBody UserDto newUser) {
        newUser.setId(Id);

        return userService.updateUser(newUser);
    }
}
