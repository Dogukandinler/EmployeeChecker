package com.example.employeechecker;

import com.example.employeechecker.dto.RoleDto;
import com.example.employeechecker.dto.UserDto;
import com.example.employeechecker.service.RoleService;
import com.example.employeechecker.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class Startup implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;

    @Override
    public void run(String... args) {
        try {
            createDummyData();
        } catch (Exception e) {
            log.error("kayitlar zaten mevcut");
        }
    }

    private void createDummyData() {
        RoleDto adminRole = new RoleDto();
        adminRole.setAuthority("ADMIN");
        adminRole = roleService.createRole(adminRole);

        RoleDto userRole = new RoleDto();
        userRole.setAuthority("USER");
        userRole = roleService.createRole(userRole);

        UserDto admin = new UserDto();
        admin.setName("admin");
        admin.setUsername("admin");
        admin.setEmail("admin@mail.com");
        admin.setPassword("pass");
        admin.setAuthorities(Set.of(adminRole));
        userService.createSystemUser(admin);

        UserDto user = new UserDto();
        user.setName("user");
        user.setUsername("user");
        user.setPassword("pass");
        user.setEmail("user@mail.com");
        user.setAuthorities(Set.of(userRole));
        userService.createSystemUser(user);

    }
}
