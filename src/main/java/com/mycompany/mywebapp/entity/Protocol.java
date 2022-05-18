package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

import java.util.Date;


public class Protocol {

    private Long id;
    private Date dateOfExamination;
    private JobPositions chairman;
    private JobPositions oneMemberOfCommission;
    private JobPositions twoMemberOfCommission;
    private JobPositions threeMemberOfCommission;
    private JobPositions fourMemberOfCommission;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "protocol_id")
//    private List<Employee> employees = new ArrayList<>();

    public Protocol() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfExamination() {
        return dateOfExamination;
    }

    public void setDateOfExamination(Date dateOfExamination) {
        this.dateOfExamination = dateOfExamination;
    }

    public JobPositions getChairman() {
        return chairman;
    }

    public void setChairman(JobPositions chairman) {
        this.chairman = chairman;
    }

    public JobPositions getOneMemberOfCommission() {
        return oneMemberOfCommission;
    }

    public void setOneMemberOfCommission(JobPositions oneMemberOfCommission) {
        this.oneMemberOfCommission = oneMemberOfCommission;
    }

    public JobPositions getTwoMemberOfCommission() {
        return twoMemberOfCommission;
    }

    public void setTwoMemberOfCommission(JobPositions twoMemberOfCommission) {
        this.twoMemberOfCommission = twoMemberOfCommission;
    }

    public JobPositions getThreeMemberOfCommission() {
        return threeMemberOfCommission;
    }

    public void setThreeMemberOfCommission(JobPositions threeMemberOfCommission) {
        this.threeMemberOfCommission = threeMemberOfCommission;
    }

    public JobPositions getFourMemberOfCommission() {
        return fourMemberOfCommission;
    }

    public void setFourMemberOfCommission(JobPositions fourMemberOfCommission) {
        this.fourMemberOfCommission = fourMemberOfCommission;
    }

    @Override
    public String toString() {
        return "\nProtocol{" +
                "\nid=" + id +
                ", \ndateOfExamination=" + dateOfExamination +
                ", \nchairman=" + chairman +
                ", \noneMemberOfCommission=" + oneMemberOfCommission +
                ", \ntwoMemberOfCommission=" + twoMemberOfCommission +
                ", \nthreeMemberOfCommission=" + threeMemberOfCommission +
                ", \nfourMemberOfCommission=" + fourMemberOfCommission +
                '}';
    }
}
