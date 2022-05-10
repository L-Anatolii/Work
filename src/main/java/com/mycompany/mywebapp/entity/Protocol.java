package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="protocols")
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, name = "dateOfExamination")
    private Date dateOfExamination;

    @Column(nullable = false, length = 45, name = "chairman")
    @Enumerated(EnumType.STRING)
    private JobPositions chairman;

    @Column(nullable = false, length = 45, name = "oneMemberOfCommission")
    @Enumerated(EnumType.STRING)
    private JobPositions oneMemberOfCommission;

    @Column(nullable = false, length = 45, name = "twoMemberOfCommission")
    @Enumerated(EnumType.STRING)
    private JobPositions twoMemberOfCommission;

    @Column(nullable = false, length = 45, name = "threeMemberOfCommission")
    @Enumerated(EnumType.STRING)
    private JobPositions threeMemberOfCommission;

    @Column(nullable = false, length = 45, name = "fourMemberOfCommission")
    @Enumerated(EnumType.STRING)
    private JobPositions fourMemberOfCommission;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "protocolId")
    private List<Employee> employees = new ArrayList<>();

    //причина проверки знаний ???

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
