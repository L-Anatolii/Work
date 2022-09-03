package com.mycompany.mywebapp.dto.jasper.protocol;

import com.mycompany.mywebapp.dto.jasper.protocol.SubJRCertificationDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SubJREmployeeDto {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String jobPosition;

    private List<SubJRCertificationDto> jasperCertification = new ArrayList<>();

    public SubJREmployeeDto() {
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

    public List<SubJRCertificationDto> getJasperCertification() {
        return jasperCertification;
    }

    public void setJasperCertification(List<SubJRCertificationDto> jasperCertification) {
        this.jasperCertification = jasperCertification;
    }

    @Override
    public String toString() {
        return '\n'+"   SubJREmployeeDto{" +
                '\n'+"      employeeId=" + employeeId +
                '\n'+"      firstName='" + firstName + '\'' +
                '\n'+"      lastName='" + lastName + '\'' +
                '\n'+"      patronymic='" + patronymic + '\'' +
                '\n'+"      jobPosition='" + jobPosition + '\'' +
              '\n'+"      jasperCertification=" + jasperCertification +
                '}';
    }
}
