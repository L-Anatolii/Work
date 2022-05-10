package com.mycompany.mywebapp.dto;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDto {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String jobPosition;

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
}
