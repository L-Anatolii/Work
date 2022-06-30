package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "patronymic")
    private String patronymic;
    @Column (name = "job_position")
    private JobPositions jobPosition;

    @OneToMany(mappedBy = "employee")
    Set<Certification> certifications;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "certification",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "safety_training_program_id"))
    private Set<SafetyTrainingProgram> programs = new HashSet<>();

    public void addProgram(SafetyTrainingProgram program){
        this.programs.add(program);
        program.getEmployees().add(this);
    }
    public void removeProgram(SafetyTrainingProgram program){
        this.programs.remove(program);
        program.getEmployees().remove(this);
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_protocol",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "protocol_id"))
    private Set<Protocol> protocols = new HashSet<>();

    public void addProtocol(Protocol protocol){
        this.protocols.add(protocol);
        protocol.getEmployees().add(this);
    }
    public void removeProtocol(Protocol protocol){
        this.protocols.remove(protocol);
        protocol.getEmployees().remove(this);
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

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    public Set<SafetyTrainingProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<SafetyTrainingProgram> programs) {
        this.programs = programs;
    }

    public Set<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<Protocol> protocols) {
        this.protocols = protocols;
    }
}
