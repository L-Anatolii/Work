package com.mycompany.mywebapp.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Component
public class RegulationDocumentDto {

    private Long documentId;
    private Integer documentNumber;
    private String titleOfDocument;
    private String approvedTheDocument;
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

    public String getApprovedTheDocument() {
        return approvedTheDocument;
    }

    public void setApprovedTheDocument(String approvedTheDocument) {
        this.approvedTheDocument = approvedTheDocument;
    }

    public String getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(String dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }


}
