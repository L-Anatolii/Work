package com.mycompany.mywebapp.dto.jasper.protocol;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JRProtocolDto {

    private Long protocolId;
    private String dateOfExamination;
    private String chairman;
    private String oneMemberOfCommission;
    private String twoMemberOfCommission;
    private String threeMemberOfCommission;
    private String fourMemberOfCommission;
    private List<SubJREmployeeDto> subReport = new ArrayList<>();

    public JRProtocolDto() {
    }
    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getDateOfExamination() {
        return dateOfExamination;
    }

    public void setDateOfExamination(String dateOfExamination) {
        this.dateOfExamination = dateOfExamination;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getOneMemberOfCommission() {
        return oneMemberOfCommission;
    }

    public void setOneMemberOfCommission(String oneMemberOfCommission) {
        this.oneMemberOfCommission = oneMemberOfCommission;
    }

    public String getTwoMemberOfCommission() {
        return twoMemberOfCommission;
    }

    public void setTwoMemberOfCommission(String twoMemberOfCommission) {
        this.twoMemberOfCommission = twoMemberOfCommission;
    }

    public String getThreeMemberOfCommission() {
        return threeMemberOfCommission;
    }

    public void setThreeMemberOfCommission(String threeMemberOfCommission) {
        this.threeMemberOfCommission = threeMemberOfCommission;
    }

    public String getFourMemberOfCommission() {
        return fourMemberOfCommission;
    }

    public void setFourMemberOfCommission(String fourMemberOfCommission) {
        this.fourMemberOfCommission = fourMemberOfCommission;
    }

    public List<SubJREmployeeDto> getSubReport() {
        return subReport;
    }

    public void setSubReport(List<SubJREmployeeDto> subReport) {
        this.subReport = subReport;
    }

    @Override
    public String toString() {
        return "JRProtocolDto{" +
                '\n'+"protocolId=" + protocolId +
                '\n'+" dateOfExamination='" + dateOfExamination + '\'' +
                '\n'+" chairman='" + chairman + '\'' +
                '\n'+" oneMemberOfCommission='" + oneMemberOfCommission + '\'' +
                '\n'+" twoMemberOfCommission='" + twoMemberOfCommission + '\'' +
                '\n'+" threeMemberOfCommission='" + threeMemberOfCommission + '\'' +
                '\n'+" fourMemberOfCommission='" + fourMemberOfCommission + '\'' +
                '\n'+" subReport=" + subReport +
                '}';
    }
}