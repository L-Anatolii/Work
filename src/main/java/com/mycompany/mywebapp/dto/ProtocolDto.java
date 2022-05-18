package com.mycompany.mywebapp.dto;

import org.springframework.stereotype.Component;

@Component
public class ProtocolDto {

    private Long protocolId;
    private String dateOfExamination;
    private String chairman;
    private String oneMemberOfCommission;
    private String twoMemberOfCommission;
    private String threeMemberOfCommission;
    private String fourMemberOfCommission;

    public ProtocolDto() {
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
}
