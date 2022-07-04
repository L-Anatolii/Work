package com.mycompany.mywebapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "certifications")
public class Certification implements Serializable {

    @EmbeddedId
    public CertificationKey  id = new CertificationKey();
//
//    @ManyToOne()
//    @MapsId("employeeId")
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    @ManyToOne
//    @MapsId("programId")
//    @JoinColumn(name = "safety_training_program_id")
//    private SafetyTrainingProgram program;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @MapsId("programId")
    @JoinColumn(name = "safety_training_program_id")
    private SafetyTrainingProgram program;

    @Column(name = "number")
    private Integer number;

    public Certification() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SafetyTrainingProgram getProgram() {
        return program;
    }

    public void setProgram(SafetyTrainingProgram program) {
        this.program = program;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", employee=" + employee +
                ", program=" + program +
                ", number=" + number +
                '}';
    }
}
