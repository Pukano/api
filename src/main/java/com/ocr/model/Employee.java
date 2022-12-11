package com.ocr.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // add getter and setter
@Entity // class corresponds to a table in DB
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;
}
