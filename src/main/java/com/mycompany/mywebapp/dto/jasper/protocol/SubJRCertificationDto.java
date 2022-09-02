package com.mycompany.mywebapp.dto.jasper.protocol;

import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import org.springframework.stereotype.Component;

@Component
public class SubJRCertificationDto {

    private Long employeeId;
    private Long programId;
    private Integer numberCertification;
    private String reason;

    private SafetyTrainingProgramDto programDto;

    public SubJRCertificationDto() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Integer getNumberCertification() {
        return numberCertification;
    }

    public void setNumberCertification(Integer numberCertification) {
        this.numberCertification = numberCertification;
    }

    public SafetyTrainingProgramDto getProgramDto() {
        return programDto;
    }

    public void setProgramDto(SafetyTrainingProgramDto programDto) {
        this.programDto = programDto;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "SubJRCertificationDto{" +
                "employeeId=" + employeeId +
                ", programId=" + programId +
                ", numberCertification=" + numberCertification +
                ", reason='" + reason + '\'' +
                ", programDto=" + programDto +
                '}';
    }
}

