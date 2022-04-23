package com.mycompany.mywebapp.entity;

import org.springframework.data.repository.CrudRepository;

public interface RegulationDocumentRepository extends CrudRepository<RegulationDocument, Long> {

    public Long countById(Long id);
}
