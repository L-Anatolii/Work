package com.mycompany.mywebapp.entity;

import javax.persistence.*;

@Entity
@Table(name="regulationDocuments")
public class RegulationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, name = "documentNumber")
    private Integer documentNumber;

    @Column(nullable = false, length = 45, name = "titleOfDocument")
    private String titleOfDocument;

    //кем утверждена

    //дата утверждения
}
