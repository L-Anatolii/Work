package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table("safety_training_program")
public class SafetyTrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title_of_program")
    private String titleOfProgram;
    @Column (name = "program_number")
    private Integer programNumber;
    @Column (name = "duration")
    private Integer duration;
    @Column (name = "approved_the_program")
    private JobPositions approvedTheProgram;
    @Column (name = "date_of_approval")
    private Date dateOfApproval;

    @OneToMany(mappedBy = "program")
    Set<Certification> certifications;

    @ManyToMany(mappedBy = "programs")
    private Set<Employee> employees = new HashSet<>();

    public SafetyTrainingProgram() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleOfProgram() {
        return titleOfProgram;
    }

    public void setTitleOfProgram(String titleOfProgram) {
        this.titleOfProgram = titleOfProgram;
    }

    public Integer getProgramNumber() {
        return programNumber;
    }

    public void setProgramNumber(Integer programNumber) {
        this.programNumber = programNumber;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public JobPositions getApprovedTheProgram() {
        return approvedTheProgram;
    }

    public void setApprovedTheProgram(JobPositions approvedTheProgram) {
        this.approvedTheProgram = approvedTheProgram;
    }

    public Date getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(Date dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
    //
//    @Override
//    public String toString() {
//        return "\nSafetyTrainingProgram{" +
//                "\nid=" + id +
//                ", \ntitleOfProgram='" + titleOfProgram +
//                ", \nprogramNumber=" + programNumber +
//                ", \nduration=" + duration +
//                ", \njobPosition=" + approvedTheProgram +
//                ", \ndateOfApproval=" + dateOfApproval +
//                '}';



