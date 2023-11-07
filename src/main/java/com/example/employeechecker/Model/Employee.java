package com.example.employeechecker.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="Employee")
@Data
public class Employee extends BaseEntity {


    private String name;

    private String surname;

    private String pcIdentifier;


}
