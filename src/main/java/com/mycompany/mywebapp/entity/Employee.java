package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "employees_safetyTrainingProgram",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "safetyTrainingProgram_id")})
    private Set<SafetyTrainingProgram> programs = new HashSet<>();



    public void addProgram(SafetyTrainingProgram program) {
        programs.add(program);
        program.getEmployees().add(this);
    }

    public void removeProgram(SafetyTrainingProgram program) {
        programs.remove(program);
        program.getEmployees().remove(this);
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public JobPositions getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPositions jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Set<SafetyTrainingProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<SafetyTrainingProgram> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", jobPosition=" + jobPosition +
                ", programs=" + programs +
                '}';
    }

}
