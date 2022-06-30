package com.mycompany.mywebapp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmployeeProgramKey implements Serializable {

    @Column(name = "employee_id")
    Long employeeId;

    @Column(name = "safety_training_program_id")
    Long programId;

    public EmployeeProgramKey() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeProgramKey that = (EmployeeProgramKey) o;

        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        return programId != null ? programId.equals(that.programId) : that.programId == null;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (programId != null ? programId.hashCode() : 0);
        return result;
    }
}
