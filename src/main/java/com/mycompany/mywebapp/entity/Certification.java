package com.mycompany.mywebapp.entity;

import javax.persistence.*;

@Entity
@Table(name="certifications")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10, name = "number")
    private Integer number;

    @OneToOne(mappedBy = "certification", cascade = CascadeType.ALL)
    private SafetyTrainingProgram program;


    public Certification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SafetyTrainingProgram getProgram() {
        return program;
    }

    public void setProgram(SafetyTrainingProgram program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "\nCertification{" +
                "\nid=" + id +
                ", \nnumber=" + number +
                ", \nprogram=" + program +
                '}';
    }
}
