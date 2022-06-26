package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table("safety_training_programs")
@Data
@AllArgsConstructor
public class SafetyTrainingProgram {
    @Id
    private Long id;
    private String titleOfProgram;
    private Integer programNumber;
    private Integer duration;
    private JobPositions approvedTheProgram;
    private Date dateOfApproval;

    private List<Certification> certifications = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();

    // Может нужно указать???
    // private Long employee_id;

    public SafetyTrainingProgram() {
    }


    //    @ManyToMany(mappedBy = "programs")
//    private Set<Employee> employees = new HashSet<>();
//
//    @OneToOne( cascade = CascadeType.ALL)
//    @JoinColumn(name = "certificationId")
//    @MappedCollection(idColumn = "safety_training_program_id")
//    private Certification certification;
//    private Set<EmployeeRef> employees = new HashSet<>();
//
//
//    public void addEmployee(Employee employee){
//        this.employees.add(new EmployeeRef(employee.getId()));
//    }
//    public Set<Long> getEmployeeIds(){
//        return this.employees.stream()
//                .map(EmployeeRef::getEmployeeId)
//                .collect(Collectors.toSet());
//    }
//    public SafetyTrainingProgram() {
//    }
//
//    @PersistenceConstructor
//    public SafetyTrainingProgram(Long id, String titleOfProgram, Integer programNumber, Integer duration, JobPositions approvedTheProgram, Date dateOfApproval, Certification certification, Set<EmployeeRef> employees) {
//        this.id = id;
//        this.titleOfProgram = titleOfProgram;
//        this.programNumber = programNumber;
//        this.duration = duration;
//        this.approvedTheProgram = approvedTheProgram;
//        this.dateOfApproval = dateOfApproval;
//        this.employees = employees;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitleOfProgram() {
//        return titleOfProgram;
//    }
//
//    public void setTitleOfProgram(String titleOfProgram) {
//        this.titleOfProgram = titleOfProgram;
//    }
//
//    public Integer getProgramNumber() {
//        return programNumber;
//    }
//
//    public void setProgramNumber(Integer programNumber) {
//        this.programNumber = programNumber;
//    }
//
//    public Integer getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Integer duration) {
//        this.duration = duration;
//    }
//
//    public JobPositions getApprovedTheProgram() {
//        return approvedTheProgram;
//    }
//
//    public void setApprovedTheProgram(JobPositions approvedTheProgram) {
//        this.approvedTheProgram = approvedTheProgram;
//    }
//
//    public Date getDateOfApproval() {
//        return dateOfApproval;
//    }
//
//    public void setDateOfApproval(Date dateOfApproval) {
//        this.dateOfApproval = dateOfApproval;
//    }
//
//    public Set<EmployeeRef> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<EmployeeRef> employees) {
//        this.employees = employees;
//    }
//
//    @Override
//    public String toString() {
//        return "\nSafetyTrainingProgram{" +
//                "\nid=" + id +
//                ", \ntitleOfProgram='" + titleOfProgram +
//                ", \nprogramNumber=" + programNumber +
//                ", \nduration=" + duration +
//                ", \njobPosition=" + approvedTheProgram +
//                ", \ndateOfApproval=" + dateOfApproval +
//                '}';
}



