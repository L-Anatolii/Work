package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="regulationDocuments")
public class RegulationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, name = "documentNumber")
    private Integer documentNumber;

    @Column(nullable = false, length = 45, name = "titleOfDocument")
    private String titleOfDocument;

    //кем утверждена(выбрать должность, подтянуть ФИО)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 45, name = "approvedTheDocument")
    private JobPositions jobPosition;

    //дата утверждения
    @Temporal(value = TemporalType.DATE)
    @Column(name = "dateOfApproval")
    private Date dateOfApproval;

    public RegulationDocument() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getTitleOfDocument() {
        return titleOfDocument;
    }

    public void setTitleOfDocument(String titleOfDocument) {
        this.titleOfDocument = titleOfDocument;
    }

    public JobPositions getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPositions jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Date getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(Date dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    @Override
    public String toString() {
        return "RegulationDocument{" +
                "id=" + id +
                ", documentNumber=" + documentNumber +
                ", titleOfDocument='" + titleOfDocument + '\'' +
                ", approvedTheDocument='" + jobPosition + '\'' +
                ", dateOfApproval=" + dateOfApproval +
                '}';
    }

}
