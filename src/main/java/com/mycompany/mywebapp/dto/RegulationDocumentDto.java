package com.mycompany.mywebapp.dto;

import org.springframework.stereotype.Component;

@Component
public class RegulationDocumentDto {

    private Long documentId;
    private Integer documentNumber;
    private String titleOfDocument;
    private String jobPosition;
    private String dateOfApproval;

    public RegulationDocumentDto() {
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
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

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(String dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }


}
