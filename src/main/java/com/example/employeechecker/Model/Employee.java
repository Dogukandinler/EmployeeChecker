package com.example.employeechecker.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Employee extends BaseEntity {


    private String Name;

    private String Surname;

    private String pcIdentifier;


}
