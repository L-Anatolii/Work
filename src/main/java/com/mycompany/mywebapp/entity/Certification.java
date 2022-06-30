package com.mycompany.mywebapp.entity;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table("certification")
public class Certification {


    @EmbeddedId
    EmployeeProgramKey id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne
    @MapsId("programId")
    @JoinColumn(name = "safety_training_program_id")
    SafetyTrainingProgram program;

    private Integer number;

    public Certification() {
    }

    public EmployeeProgramKey getId() {
        return id;
    }

    public void setId(EmployeeProgramKey id) {
        this.id = id;
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
}
