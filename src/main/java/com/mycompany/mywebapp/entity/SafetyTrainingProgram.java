package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

import java.util.Date;

public class SafetyTrainingProgram {

    private Long id;
    private String titleOfProgram;
    private Integer programNumber;
    private Integer duration;
    private JobPositions jobPosition;
    private Date dateOfApproval;

//    @ManyToMany(mappedBy = "programs")
//    private Set<Employee> employees = new HashSet<>();
//
//    @OneToOne( cascade = CascadeType.ALL)
//    @JoinColumn(name = "certificationId")
//    private Certification certification;

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


    @Override
    public String toString() {
        return "\nSafetyTrainingProgram{" +
                "\nid=" + id +
                ", \ntitleOfProgram='" + titleOfProgram +
                ", \nprogramNumber=" + programNumber +
                ", \nduration=" + duration +
                ", \njobPosition=" + jobPosition +
                ", \ndateOfApproval=" + dateOfApproval +
                '}';
    }

}
