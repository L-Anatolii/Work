package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.entity.RegulationDocument;
import com.mycompany.mywebapp.entity.RegulationDocumentRepository;
import com.mycompany.mywebapp.exception.RegulationDocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegulationDocumentServise {

    @Autowired
    private RegulationDocumentRepository repoDocument;

    public List<RegulationDocument> listAll(){
        return (List<RegulationDocument>) repoDocument.findAll();
    }

    public void save(RegulationDocument regulationDocument){
        repoDocument.save(regulationDocument);
    }

    public RegulationDocument get(Long id) throws RegulationDocumentNotFoundException {
        Optional<RegulationDocument> result = repoDocument.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new RegulationDocumentNotFoundException("Could not find any regulation documents with ID"+ id);
    }

    public void delete(Long id) throws RegulationDocumentNotFoundException{
        Long count = repoDocument.countById(id);
        if(count == null || count == 0){
            throw new RegulationDocumentNotFoundException("Could not find any regulation documents with ID"+ id);
        }
        repoDocument.deleteById(id);
    }
}
