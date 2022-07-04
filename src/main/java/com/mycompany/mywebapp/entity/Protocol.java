package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "protocols")
public class Protocol {

    @Id
    private Long id;
    @Column(name = "date_of_examination")
    private Date dateOfExamination;
    @Column (name = "chairman")
    private JobPositions chairman;
    @Column (name = "one_member_of_commission")
    private JobPositions oneMemberOfCommission;
    @Column (name = "two_member_of_commission")
    private JobPositions twoMemberOfCommission;
    @Column (name = "three_member_of_commission")
    private JobPositions threeMemberOfCommission;
    @Column (name = "four_member_of_commission")
    private JobPositions fourMemberOfCommission;

//    @ManyToMany(mappedBy = "protocols")
//    private Set<Employee> employees = new HashSet<>();

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


}