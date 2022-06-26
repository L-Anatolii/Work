package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.dto.RegulationDocumentDto;
import com.mycompany.mywebapp.entity.RegulationDocument;
import com.mycompany.mywebapp.exception.RegulationDocumentNotFoundException;
import com.mycompany.mywebapp.jdbc.dao.RegulationDocumentDao;
import com.mycompany.mywebapp.repository.EmployeeRepository;
import com.mycompany.mywebapp.repository.RegulationDocumentRepository;
import com.mycompany.mywebapp.сonverter.RegulationDocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegulationDocumentServise {

    @Autowired
    private RegulationDocumentConverter converter;

    @Autowired
    private RegulationDocumentRepository regulationDocumentRepository;


    public List<RegulationDocumentDto> getAllRegulationDocuments(){
        List<RegulationDocument> documents = (List<RegulationDocument>) regulationDocumentRepository.findAll();
        return converter.entityToDto(documents);
    }

    public void save(RegulationDocumentDto regulationDocumentDto){
        regulationDocumentRepository.save(converter.dtoToEntity(regulationDocumentDto));
    }

    public RegulationDocumentDto findById(Long id) throws RegulationDocumentNotFoundException {
        Optional<RegulationDocument> document = regulationDocumentRepository.findById(id);
        if(document.isPresent()){
            return converter.entityToDto(document.get());
        }
        throw new RegulationDocumentNotFoundException("Could not find any regulation documents with ID"+ id);
    }

    public void delete(Long id) throws RegulationDocumentNotFoundException {
        Long count = regulationDocumentRepository.countById(id);
        if(count == null || count == 0){
            throw new RegulationDocumentNotFoundException("Could not find any regulation documents with ID"+ id);
        }
        regulationDocumentRepository.deleteById(id);
    }
}
