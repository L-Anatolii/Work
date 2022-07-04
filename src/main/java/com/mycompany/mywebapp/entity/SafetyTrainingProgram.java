package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "safety_training_programs")
public class SafetyTrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Column(name = "title_of_program")
    private String titleOfProgram;
    @Column (name = "program_number")
    private Integer programNumber;
    @Column (name = "duration")
    private Integer duration;
    @Column (name = "approved_the_program")
    private JobPositions approvedTheProgram;
    @Column (name = "date_of_approval")
    private Date dateOfApproval;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Certification> certifications = new HashSet<>();

    public SafetyTrainingProgram() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleOfProgram() {
        return titleOfProgram;
    }

    public void setTitleOfProgram(String titleOfProgram) {
        this.titleOfProgram = titleOfProgram;
    }

    public Integer getProgramNumber() {
        return programNumber;
    }

    public void setProgramNumber(Integer programNumber) {
        this.programNumber = programNumber;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public JobPositions getApprovedTheProgram() {
        return approvedTheProgram;
    }

    public void setApprovedTheProgram(JobPositions approvedTheProgram) {
        this.approvedTheProgram = approvedTheProgram;
    }

    public Date getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(Date dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SafetyTrainingProgram program = (SafetyTrainingProgram) o;

        if (id != null ? !id.equals(program.id) : program.id != null) return false;
        if (titleOfProgram != null ? !titleOfProgram.equals(program.titleOfProgram) : program.titleOfProgram != null)
            return false;
        if (programNumber != null ? !programNumber.equals(program.programNumber) : program.programNumber != null)
            return false;
        if (duration != null ? !duration.equals(program.duration) : program.duration != null) return false;
        if (approvedTheProgram != program.approvedTheProgram) return false;
        if (dateOfApproval != null ? !dateOfApproval.equals(program.dateOfApproval) : program.dateOfApproval != null)
            return false;
        return certifications != null ? certifications.equals(program.certifications) : program.certifications == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titleOfProgram != null ? titleOfProgram.hashCode() : 0);
        result = 31 * result + (programNumber != null ? programNumber.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (approvedTheProgram != null ? approvedTheProgram.hashCode() : 0);
        result = 31 * result + (dateOfApproval != null ? dateOfApproval.hashCode() : 0);
        result = 31 * result + (certifications != null ? certifications.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SafetyTrainingProgram{" +
                "id=" + id +
                ", titleOfProgram='" + titleOfProgram + '\'' +
                ", programNumber=" + programNumber +
                ", duration=" + duration +
                ", approvedTheProgram=" + approvedTheProgram +
                ", dateOfApproval=" + dateOfApproval +
                ", certifications=" + certifications.size() +
                '}';
    }
}




