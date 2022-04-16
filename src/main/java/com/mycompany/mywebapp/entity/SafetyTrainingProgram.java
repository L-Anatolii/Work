package com.mycompany.mywebapp.entity;


import javax.persistence.*;

@Entity
@Table(name="safetyTrainingPrograms")
public class SafetyTrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, name = "titleOfDocument")
    private String titleOfDocument;

    @Column(nullable = false, length = 45, name = "programNumber")
    private Integer programNumber;

    @Column(nullable = false, length = 45, name = "duration")
    private Integer duration;

    //кем утверждена

    //дата утверждения

}
