package com.mycompany.mywebapp.сonverter;

import com.mycompany.mywebapp.dto.RegulationDocumentDto;
import com.mycompany.mywebapp.entity.RegulationDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegulationDocumentConverter {

    @Autowired
    TypeConverter converter;

    public RegulationDocumentDto entityToDto(RegulationDocument document){
        RegulationDocumentDto dto = new RegulationDocumentDto();
        dto.setDocumentId(document.getId());
        dto.setDocumentNumber(document.getDocumentNumber());
        dto.setTitleOfDocument(document.getTitleOfDocument());
        dto.setApprovedTheDocument(TypeConverter.enamToString(document.getApprovedTheDocument()));
        dto.setDateOfApproval(converter.dateToString((Date) document.getDateOfApproval()));
        return dto;
    }

    public List<RegulationDocumentDto> entityToDto (List<RegulationDocument> documents){
        return documents.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public RegulationDocument dtoToEntity(RegulationDocumentDto dto){
        RegulationDocument document =  new RegulationDocument();
        document.setId(dto.getDocumentId());
        document.setDocumentNumber(dto.getDocumentNumber());
        document.setTitleOfDocument(dto.getTitleOfDocument());
        document.setApprovedTheDocument(TypeConverter.StringToEnam(dto.getApprovedTheDocument()));
        document.setDateOfApproval(converter.stringToDate(dto.getDateOfApproval()));
        return document;
    }

    public List<RegulationDocument> dtoToEntity(List<RegulationDocumentDto> dto){
        return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());
    }

}
