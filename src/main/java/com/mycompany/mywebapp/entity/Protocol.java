package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import javax.persistence.*;
import java.util.*;

@Entity
@NamedEntityGraph(name = "protocol-with-employees",
        attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode("dateOfExamination"),
                @NamedAttributeNode("chairman"),
                @NamedAttributeNode("oneMemberOfCommission"),
                @NamedAttributeNode("twoMemberOfCommission"),
                @NamedAttributeNode("threeMemberOfCommission"),
                @NamedAttributeNode("fourMemberOfCommission"),
                @NamedAttributeNode(value = "employees", subgraph = "employees-subgraph" ),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "employees-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("id"),
                                @NamedAttributeNode("firstName"),
                                @NamedAttributeNode("lastName"),
                                @NamedAttributeNode("patronymic"),
                                @NamedAttributeNode("jobPosition")
                        }
                )
        }
)
@Table(name = "protocols")
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_of_examination")
    @Temporal(TemporalType.DATE)
    private Date dateOfExamination;
    @Column (name = "chairman")
    private Long chairman;
    @Column (name = "one_member_of_commission")
    private Long oneMemberOfCommission;
    @Column (name = "two_member_of_commission")
    private Long twoMemberOfCommission;
    @Column (name = "three_member_of_commission")
    private Long threeMemberOfCommission;
    @Column (name = "four_member_of_commission")
    private Long fourMemberOfCommission;


    //заменить на fetch = FetchType.LAZY//
    @ManyToMany(mappedBy = "protocols", fetch = FetchType.EAGER)
    @OrderBy("id")
    private Set<Employee> employees = new HashSet<>();

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
