package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="safetyTrainingPrograms")
public class SafetyTrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, name = "titleOfProgram")
    private String titleOfProgram;

    @Column(nullable = false, length = 5, name = "programNumber")
    private Integer programNumber;

    @Column(nullable = false, length = 5, name = "duration")
    private Integer duration;

    //кем утверждена(выбрать должность, подтянуть ФИО)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 45, name = "approvedTheProgram")
    private JobPositions jobPosition;

    //дата утверждения
    @Column(name = "dateOfApproval")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfApproval;

    @ManyToMany(mappedBy = "programs")
    private Set<Employee> employees;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "safetyTrainingProgramsId")
//    private Set<Certification> certifications;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificationId")
    private Certification certification;

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

    public JobPositions getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPositions jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Date getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(Date dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    @Override
    public String toString() {
        return "SafetyTrainingProgram{" +
                "id=" + id +
                ", titleOfProgram='" + titleOfProgram + '\'' +
                ", programNumber=" + programNumber +
                ", duration=" + duration +
                ", jobPosition=" + jobPosition +
                ", dateOfApproval=" + dateOfApproval +
                ", employees=" + employees +
                ", certification=" + certification +
                '}';
    }
}
