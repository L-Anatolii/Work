package com.mycompany.mywebapp.dto.jasper.protocol;

import com.mycompany.mywebapp.dto.SafetyTrainingProgramDto;
import org.springframework.stereotype.Component;

@Component
public class SubJRCertificationDto {

    private Integer numberCertification;
    private String reason;
    private String titleOfProgram;

    private Integer programNumber;

    private Integer duration;

    private String approvedTheProgram;

    private String dateOfApproval;

    public Integer getNumberCertification() {
        return numberCertification;
    }

    public void setNumberCertification(Integer numberCertification) {
        this.numberCertification = numberCertification;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    @Override
    public String toString() {
        return "SubJRCertificationDto{" +
                '\n'+"         numberCertification=" + numberCertification +
                '\n'+"         reason='" + reason + '\'' +
                '\n'+"         titleOfProgram='" + titleOfProgram + '\'' +
                '\n'+"         programNumber=" + programNumber +
                '\n'+"         duration=" + duration +
                '\n'+"         approvedTheProgram='" + approvedTheProgram + '\'' +
                '\n'+"         dateOfApproval='" + dateOfApproval + '\'' +
                '}';
    }
}

