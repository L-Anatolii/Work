package com.mycompany.mywebapp.repository;

import com.mycompany.mywebapp.entity.RegulationDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulationDocumentRepository extends CrudRepository<RegulationDocument, Long> {
    Long countById(Long id);
}
