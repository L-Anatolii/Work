package com.mycompany.mywebapp.entity;

import org.springframework.stereotype.Component;
@Component
public class Certification {

    private Long id;
    private Integer number;

//    private SafetyTrainingProgram program;

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


    @Override
    public String toString() {
        return "\nCertification{" +
                "\nid=" + id +
                ", \nnumber=" + number +
                '}';
    }
}
