package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, name = "firstName")
    private String firstName;

    @Column(nullable = false, length = 45, name = "lastName")
    private String lastName;

    @Column(nullable = false, length = 45, name = "patronymic")
    private String patronymic;

    @Column(nullable = false, length = 45, name = "jobPosition")
    @Enumerated(EnumType.STRING)
    private JobPositions jobPosition;




}
