package com.example.employeechecker.service;

import com.example.employeechecker.dto.UserDto;
import com.example.employeechecker.mapper.UserMapper;
import com.example.employeechecker.model.User;
import com.example.employeechecker.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

  private final RoleService roleService;
  private final UserRepository repository;
  private final UserMapper mapper;
  private final PasswordEncoder passwordEncoder;

  public List<UserDto> getUsers() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }

  public Optional<User> getById(Long id) {
    return repository.findById(id);
  }

  public User getByUsername(String username) {
    var user = repository.findByUsername(username);
    if (user.isEmpty()) {
      throw new EntityNotFoundException("user not found!");
    }
    return user.get();
  }

  public UserDto getDtoByUsername(String username) {
    return mapper.toDto(getByUsername(username));
  }

  public UserDto createUser(UserDto dto) {
    var role = roleService.getByAuthority("USER");
    dto.setAuthorities(Set.of(role));
    dto.setPassword(passwordEncoder.encode(dto.getPassword()));
    return mapper.toDto(repository.save(mapper.toEntity(dto)));
  }
  public UserDto createSystemUser(UserDto dto) {
    return mapper.toDto(repository.save(mapper.toEntity(dto)));
  }

  public  void deleteOneUser(Long username) {
    repository.deleteById(username);
  }

  public UserDto updateUser(UserDto dto) {
    var existing = getById(dto.getId());
    if (existing.isEmpty()) {
      throw new EntityNotFoundException();
    }
    mapper.updatePartial(existing.get(), dto);
    return mapper.toDto(repository.save(existing.get()));
  }
}
