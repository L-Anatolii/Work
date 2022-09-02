package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "employee-with-protocols",
        attributeNodes = {
            @NamedAttributeNode("id"),
            @NamedAttributeNode("firstName"),
            @NamedAttributeNode("lastName"),
            @NamedAttributeNode("patronymic"),
            @NamedAttributeNode("jobPosition"),
            @NamedAttributeNode(value = "protocols", subgraph = "protocols-subgraph" ),
        },
        subgraphs = {
            @NamedSubgraph(
                    name = "protocols-subgraph",
                    attributeNodes = {
                            @NamedAttributeNode("id"),
                            @NamedAttributeNode("dateOfExamination"),
                            @NamedAttributeNode("chairman"),
                            @NamedAttributeNode("oneMemberOfCommission"),
                            @NamedAttributeNode("twoMemberOfCommission"),
                            @NamedAttributeNode("threeMemberOfCommission"),
                            @NamedAttributeNode("fourMemberOfCommission")
                    }
            )
        }
)
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "patronymic")
    private String patronymic;
    @Column (name = "job_position")
    private JobPositions jobPosition;

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Certification> certifications = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,
                           CascadeType.REFRESH,
                           CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_protocol",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "protocol_id"))
    private Set<Protocol> protocols = new HashSet<>();

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public JobPositions getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPositions jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    public Set<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<Protocol> protocols) {
        this.protocols = protocols;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (patronymic != null ? !patronymic.equals(employee.patronymic) : employee.patronymic != null) return false;
        if (jobPosition != employee.jobPosition) return false;
        if (certifications != null ? !certifications.equals(employee.certifications) : employee.certifications != null)
            return false;
        return protocols != null ? protocols.equals(employee.protocols) : employee.protocols == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (jobPosition != null ? jobPosition.hashCode() : 0);
        result = 31 * result + (certifications != null ? certifications.hashCode() : 0);
        result = 31 * result + (protocols != null ? protocols.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", jobPosition=" + jobPosition +
                ", certifications=" + certifications.size() +
                ", protocols=" + protocols.size() +
                '}';
    }
}
