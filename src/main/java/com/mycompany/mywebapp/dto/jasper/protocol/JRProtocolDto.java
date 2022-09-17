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
    private Long chairman;
    private Long oneMemberOfCommission;
    private Long twoMemberOfCommission;
    private Long threeMemberOfCommission;
    private Long fourMemberOfCommission;
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

    public Long getChairman() {
        return chairman;
    }

    public void setChairman(Long chairman) {
        this.chairman = chairman;
    }

    public Long getOneMemberOfCommission() {
        return oneMemberOfCommission;
    }

    public void setOneMemberOfCommission(Long oneMemberOfCommission) {
        this.oneMemberOfCommission = oneMemberOfCommission;
    }

    public Long getTwoMemberOfCommission() {
        return twoMemberOfCommission;
    }

    public void setTwoMemberOfCommission(Long twoMemberOfCommission) {
        this.twoMemberOfCommission = twoMemberOfCommission;
    }

    public Long getThreeMemberOfCommission() {
        return threeMemberOfCommission;
    }

    public void setThreeMemberOfCommission(Long threeMemberOfCommission) {
        this.threeMemberOfCommission = threeMemberOfCommission;
    }

    public Long getFourMemberOfCommission() {
        return fourMemberOfCommission;
    }

    public void setFourMemberOfCommission(Long fourMemberOfCommission) {
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