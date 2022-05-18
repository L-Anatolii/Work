package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private JobPositions jobPosition;

//   private Set<SafetyTrainingProgram> programs = new HashSet<>();
//
//   public void addProgram(SafetyTrainingProgram program) {
//       programs.add(program);
//       program.getEmployees().add(this);
//   }
//   public void removeProgram(SafetyTrainingProgram program) {
//       programs.remove(program);
//       program.getEmployees().remove(this);
//   }

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

    @Override
    public String toString() {
        return "\nEmployee{" +
                "\nid=" + id +
                ", \nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \npatronymic='" + patronymic + '\'' +
                ", \njobPosition=" + jobPosition +
                '}';
    }

}
