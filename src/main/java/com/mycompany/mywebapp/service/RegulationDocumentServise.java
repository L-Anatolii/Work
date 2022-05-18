package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.RegulationDocumentDto;
import com.mycompany.mywebapp.entity.RegulationDocument;
import com.mycompany.mywebapp.exception.RegulationDocumentNotFoundException;
import com.mycompany.mywebapp.jdbc.dao.RegulationDocumentDao;
import com.mycompany.mywebapp.сonverter.RegulationDocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegulationDocumentServise {

    @Autowired
    private RegulationDocumentDao documentDao;

    @Autowired
    private RegulationDocumentConverter converter;


    public List<RegulationDocumentDto> getAllRegulationDocuments(){
        List<RegulationDocument> documents = documentDao.findAll();
        return converter.entityToDto(documents);
    }

    public void save(RegulationDocumentDto regulationDocumentDto){
        documentDao.save(converter.dtoToEntity(regulationDocumentDto));
    }

    public RegulationDocumentDto findById(Long id) {
        RegulationDocument document = documentDao.findById(id);
        return converter.entityToDto(document);
    }

    public void update(Long id, RegulationDocumentDto documentDto) {
        documentDao.update(id, converter.dtoToEntity(documentDto));
    }

    public void delete(Long id){
        documentDao.delete(id);
    }
}
