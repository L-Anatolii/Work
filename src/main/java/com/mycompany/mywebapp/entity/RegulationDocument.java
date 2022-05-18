package com.mycompany.mywebapp.entity;

import com.mycompany.mywebapp.service.Positions.JobPositions;

import java.util.Date;

public class RegulationDocument {


    private Long id;
    private Integer documentNumber;
    private String titleOfDocument;
    private JobPositions jobPosition;
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
        return "\nRegulationDocument{" +
                "\nid=" + id +
                ", \ndocumentNumber=" + documentNumber +
                ", \ntitleOfDocument='" + titleOfDocument + '\'' +
                ", \njobPosition=" + jobPosition +
                ", \ndateOfApproval=" + dateOfApproval +
                '}';
    }

}
