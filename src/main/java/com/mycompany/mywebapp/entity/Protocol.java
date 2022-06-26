package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table("protocols")
public class Protocol {
    @Id
    private Long id;
    private Date dateOfExamination;
    private JobPositions chairman;
    private JobPositions oneMemberOfCommission;
    private JobPositions twoMemberOfCommission;
    private JobPositions threeMemberOfCommission;
    private JobPositions fourMemberOfCommission;


    private List<Employee> employees = new ArrayList<>();

    public Protocol() {
    }

    @PersistenceConstructor
    public Protocol(Long id, Date dateOfExamination, JobPositions chairman, JobPositions oneMemberOfCommission, JobPositions twoMemberOfCommission, JobPositions threeMemberOfCommission, JobPositions fourMemberOfCommission) {
        this.id = id;
        this.dateOfExamination = dateOfExamination;
        this.chairman = chairman;
        this.oneMemberOfCommission = oneMemberOfCommission;
        this.twoMemberOfCommission = twoMemberOfCommission;
        this.threeMemberOfCommission = threeMemberOfCommission;
        this.fourMemberOfCommission = fourMemberOfCommission;

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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
