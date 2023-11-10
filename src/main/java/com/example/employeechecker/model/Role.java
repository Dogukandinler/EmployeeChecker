package com.example.employeechecker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
public class Role extends BaseEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority_name", unique = true)
    private String authority;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "authorities")
    @JsonIgnore
    private Set<User> users = new HashSet<>();
}
