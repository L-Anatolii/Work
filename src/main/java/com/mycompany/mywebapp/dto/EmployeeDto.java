package com.mycompany.mywebapp.dto;

import com.mycompany.mywebapp.entity.Certification;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EmployeeDto {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String jobPosition;
    private Set<Certification> certification;

    public EmployeeDto() {
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public void setCertification(Set<Certification> certification) {
        this.certification = certification;
    }

    public Set<Certification> getCertification() {
        return certification;
    }
}
