package com.mycompany.mywebapp.dto;

import com.mycompany.mywebapp.entity.Employee;
import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Component
public class SafetyTrainingProgramDto {

    private Long programId;
    private String titleOfProgram;
    private Integer programNumber;
    private Integer duration;
    private String approvedTheProgram;
    private String dateOfApproval;
//    private Set<Employee> employees;

    public SafetyTrainingProgramDto() {
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
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

    public String getApprovedTheProgram() {
        return approvedTheProgram;
    }

    public void setApprovedTheProgram(String approvedTheProgram) {
        this.approvedTheProgram = approvedTheProgram;
    }

    public String getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(String dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }


}
