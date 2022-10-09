package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "regulationdocuments")
public class RegulationDocument {

    @Id
    private Long id;
    private Integer documentNumber;
    private String titleOfDocument;
    private JobPositions approvedTheDocument;
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

    public JobPositions getApprovedTheDocument() {
        return approvedTheDocument;
    }

    public void setApprovedTheDocument(JobPositions approvedTheDocument) {
        this.approvedTheDocument = approvedTheDocument;
    }

    public Date getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(Date dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }


    @Override
    public String toString() {
        return "\nRegulationDocument{" +
                "\nid=" + id +
                ", \ndocumentNumber=" + documentNumber +
                ", \ntitleOfDocument='" + titleOfDocument + '\'' +
                ", \njobPosition=" + approvedTheDocument +
                ", \ndateOfApproval=" + dateOfApproval +
                '}';
    }

}
