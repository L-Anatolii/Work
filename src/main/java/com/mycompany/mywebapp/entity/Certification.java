package com.mycompany.mywebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table("certifications")
@Data
@AllArgsConstructor
public class Certification {

    @Id
    private Long certification_id;
    private Long employee_id;
    private Long safety_training_program_id;
    private Integer number;


    public Certification() {
    }

}
